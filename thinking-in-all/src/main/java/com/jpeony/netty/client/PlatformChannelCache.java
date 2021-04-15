package com.jpeony.netty.client;

import io.netty.channel.Channel;

public class PlatformChannelCache {
  public static Channel channel = null;
  
  public static void setCache(Channel channel1) {
    channel = channel1;
  }
  
  public static Channel getCache() {
    return channel;
  }
}
