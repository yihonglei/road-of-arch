package com.jpeony.netty.mq.common;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yihonglei
 */
public class ChannelCache {

    private ChannelCache() {

    }

    private static class SingleCache {
        private static final ConcurrentHashMap<String, Channel> SINGLETON = new ConcurrentHashMap<>();
    }

    public static void put(String clientId, Channel channel) {
        SingleCache.SINGLETON.put(clientId, channel);
    }

    public static Channel get(String clientId) {
        return SingleCache.SINGLETON.get(clientId);
    }
}
