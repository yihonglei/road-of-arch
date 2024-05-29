package com.jpeony.netty.mq.server;

import com.jpeony.netty.mq.common.NettyDecoder;
import com.jpeony.netty.mq.common.NettyEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.net.InetSocketAddress;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yihonglei
 */
public class NettyServer {
    private final ServerBootstrap serverBootstrap;
    private final EventLoopGroup bossGroup;
    private final EventLoopGroup workerGroup;

    public NettyServer() {
        this.serverBootstrap = new ServerBootstrap();
        bossGroup = new NioEventLoopGroup(1, new ThreadFactory() {
            private AtomicInteger threadIndex = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, String.format("NettyServerNIOBoss_%d", this.threadIndex.incrementAndGet()));
            }
        });
        workerGroup = new NioEventLoopGroup(2, new ThreadFactory() {
            private AtomicInteger threadIndex = new AtomicInteger(0);
            private int threadTotal = 3;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, String.format("NettyServerNIOWorker_%d_%d", threadTotal, this.threadIndex.incrementAndGet()));
            }
        });
    }

    public void start() {
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .option(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .localAddress(new InetSocketAddress("127.0.0.1", 8888))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        configChannel(ch);
                    }
                });

        try {
            serverBootstrap.bind().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected ChannelPipeline configChannel(SocketChannel ch) {
        return ch.pipeline()
                .addLast(new NettyEncoder())
                .addLast(new NettyDecoder())
                .addLast(new NettyServerHandler());
    }
}
