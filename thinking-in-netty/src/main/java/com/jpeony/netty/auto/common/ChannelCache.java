package com.jpeony.netty.auto.common;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yihonglei
 */
public class ChannelCache {
    private static ConcurrentHashMap<String, Channel> cache = new ConcurrentHashMap<>();

    public static void put(String clientId, Channel channel) {
        cache.put(clientId, channel);
    }

    public static Channel get(String clientId) {
        return cache.get(clientId);
    }
}
