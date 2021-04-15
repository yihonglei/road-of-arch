package com.jpeony.ipc.tcp.client;


import com.jpeony.protobuf.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyBrokerClient {
    public Logger log = LoggerFactory.getLogger(getClass());

    public static String HOST = System.getProperty("ipc.host", "127.0.0.1");

    public static int PORT = Integer.valueOf(System.getProperty("ipc.port", "17777")).intValue();

    private EventLoopGroup loop = (EventLoopGroup) new NioEventLoopGroup();

    public void run(Message.MessageData msgData) throws Exception {
        try {
            ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
            cachedThreadPool.execute(() -> doConnect(new Bootstrap(), this.loop, msgData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Bootstrap doConnect(Bootstrap bootstrap, EventLoopGroup eventLoopGroup, Message.MessageData msgData) {
        try {
            if (bootstrap != null) {
                bootstrap.group(eventLoopGroup);
                bootstrap.channel(NioSocketChannel.class);
                bootstrap.handler((ChannelHandler) new Object(this));
                bootstrap.remoteAddress(HOST, PORT);
                ChannelFuture f = bootstrap.connect().sync();
                this.log.info("开始向 ipc server传送指令........");
                f.channel().writeAndFlush(msgData);
                f.channel().closeFuture().sync();
                this.log.info("broker client连接ipc server的f.channel().closeFuture().sync()执行了........");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
            this.log.info("broker client连接ipc server的eventLoopGroup.shutdownGracefully()关闭了..........");
        }
        return bootstrap;
    }
}
