package com.jpeony.netty.auto.server;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yihonglei
 */
public class NettyServerManager {
    private static ConcurrentHashMap<String, Channel> manager = new ConcurrentHashMap<>();

    public static void put(String clientId, Channel channel) {
        manager.put(clientId, channel);
    }

    public static Channel get(String clientId) {
        return manager.get(clientId);
    }
}
