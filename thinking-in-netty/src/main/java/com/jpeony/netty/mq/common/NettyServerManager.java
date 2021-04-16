package com.jpeony.netty.mq.common;

import com.jpeony.netty.mq.server.NettyServer;

/**
 * @author yihonglei
 */
public class NettyServerManager {
    private static NettyServerManager instance = new NettyServerManager();
    private final NettyServer nettyServer;

    private NettyServerManager() {
        nettyServer = new NettyServer();
    }

    public static NettyServerManager getInstance() {
        return instance;
    }

    public void start() {
        nettyServer.start();
    }
}
