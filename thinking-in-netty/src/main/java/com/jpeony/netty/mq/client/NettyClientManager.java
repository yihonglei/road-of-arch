package com.jpeony.netty.mq.client;

import com.jpeony.netty.mq.common.Message;

/**
 * @author yihonglei
 */
public class NettyClientManager {
    private static NettyClientManager instance = new NettyClientManager();
    private final NettyClient nettyClient;

    private NettyClientManager() {
        nettyClient = new NettyClient();
    }

    public static NettyClientManager getInstance() {
        return instance;
    }

    public void send(final Message message) throws InterruptedException {
        nettyClient.invokeOneWay(message);
    }

    public void start() {
        nettyClient.start();
    }
}
