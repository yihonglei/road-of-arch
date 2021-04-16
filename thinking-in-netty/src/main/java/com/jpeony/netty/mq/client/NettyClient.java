package com.jpeony.netty.mq.client;

import com.jpeony.netty.mq.common.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yihonglei
 */
public class NettyClient {
    private final Bootstrap bootstrap;
    private final EventLoopGroup workerGroup;
    private final ConcurrentHashMap<String, ChannelWrapper> channelTables = new ConcurrentHashMap<>();
    private final Lock lockChannelTables = new ReentrantLock();

    public static String HOST = System.getProperty("remote.host", "127.0.0.1");
    public static int PORT = Integer.parseInt(System.getProperty("remote.port", "8888"));

    public NettyClient() {
        bootstrap = new Bootstrap();
        this.workerGroup = new NioEventLoopGroup(1, new ThreadFactory() {
            private AtomicInteger threadIndex = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, String.format("NettyClientSelector_%d", this.threadIndex.incrementAndGet()));
            }
        });
    }

    public void start() {
        this.bootstrap.group(workerGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new NettyClientChannelInitializer());
    }

    public void invokeOneWay(final Message message) throws InterruptedException {
        final Channel channel = this.getAndCreateChannel(message.getClientId());
        if (channel != null && channel.isActive()) {
            channel.writeAndFlush(message);
        }
    }

    private Channel getAndCreateChannel(String clientId) throws InterruptedException {
        ChannelWrapper cw = this.channelTables.get(clientId);
        if (cw != null && cw.isOK()) {
            return cw.getChannel();
        }

        return this.createChannel(clientId);
    }

    private Channel createChannel(String clientId) throws InterruptedException {
        ChannelWrapper cw = this.channelTables.get(clientId);
        if (cw != null && cw.isOK()) {
            return cw.getChannel();
        }

        if (this.lockChannelTables.tryLock(3000, TimeUnit.MILLISECONDS)) {
            try {
                boolean createNewConnection;
                cw = this.channelTables.get(clientId);
                if (cw != null) {
                    if (cw.isOK()) {
                        return cw.getChannel();
                    } else if (!cw.getChannelFuture().isDone()) {
                        createNewConnection = false;
                    } else {
                        this.channelTables.remove(clientId);
                        createNewConnection = true;
                    }
                } else {
                    createNewConnection = true;
                }

                if (createNewConnection) {
                    ChannelFuture channelFuture = this.bootstrap.connect(HOST, PORT);
                    cw = new ChannelWrapper(channelFuture);
                    this.channelTables.put(clientId, cw);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.lockChannelTables.unlock();
            }
        }

        if (cw != null) {
            ChannelFuture channelFuture = cw.getChannelFuture();
            if (channelFuture.awaitUninterruptibly(3000)) {
                if (cw.isOK()) {
                    return cw.getChannel();
                }
            }
        }

        return null;
    }

    static class ChannelWrapper {
        private final ChannelFuture channelFuture;

        public ChannelWrapper(ChannelFuture channelFuture) {
            this.channelFuture = channelFuture;
        }

        public boolean isOK() {
            return this.channelFuture.channel() != null && this.channelFuture.channel().isActive();
        }

        public boolean isWritable() {
            return this.channelFuture.channel().isWritable();
        }

        private Channel getChannel() {
            return this.channelFuture.channel();
        }

        public ChannelFuture getChannelFuture() {
            return channelFuture;
        }
    }
}
