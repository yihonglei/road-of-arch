package com.jpeony.netty.client.heart;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyClient {
    public Logger log = LoggerFactory.getLogger(getClass());

    public static String HOST = System.getProperty("remote.host", "127.0.0.1");

    public static int PORT = Integer.valueOf(System.getProperty("remote.port", "19999")).intValue();

    private static final int READER_IDLE_TIME_SECONDS = 0;

    public static final int WRITER_IDLE_TIME_SECONDS = Integer.valueOf(System.getProperty("writer.idle.time.seconds", "5")).intValue();

    private static final int ALL_IDLE_TIME_SECONDS = 0;

    private EventLoopGroup loop = (EventLoopGroup) new NioEventLoopGroup();

    public void run() throws Exception {
        try {
            System.getProperties();
            doConnect(new Bootstrap(), this.loop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Bootstrap doConnect(Bootstrap bootstrap, EventLoopGroup eventLoopGroup) {
        try {
            if (bootstrap != null) {
                bootstrap.group(eventLoopGroup);
                bootstrap.channel(NioSocketChannel.class);
                bootstrap.option(ChannelOption.SO_KEEPALIVE, Boolean.valueOf(true));
                bootstrap.handler((ChannelHandler) new Object(this));
                bootstrap.remoteAddress(HOST, PORT);
                ChannelFuture f = bootstrap.connect().addListener(futureListener -> {
                    EventLoop eventLoop = futureListener.channel().eventLoop();
                    if (!futureListener.isSuccess()) {
                        this.log.warn("连接服务器失败，5s 后重新尝试连接！");
                        futureListener.channel().eventLoop().schedule((), 5L, TimeUnit.SECONDS);
                    }
                });
                f.channel().closeFuture().sync();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bootstrap;
    }
}
