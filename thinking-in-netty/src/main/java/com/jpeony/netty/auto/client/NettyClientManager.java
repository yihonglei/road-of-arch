package com.jpeony.netty.auto.client;

import com.jpeony.netty.auto.common.MessageData;

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

    public void send(final MessageData messageData) throws InterruptedException {
        nettyClient.invokeOneWay(messageData);
    }

    public void start() {
        nettyClient.start();
    }
}
