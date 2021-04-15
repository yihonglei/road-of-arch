package com.jpeony.ipc.tcp.client;

import com.jpeony.protobuf.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Simulator {
  private static final Logger logger = LoggerFactory.getLogger(Simulator.class);
  
  static final String HOST = System.getProperty("host", "127.0.0.1");
  
  static final int PORT = Integer.parseInt(System.getProperty("port", "17777"));
  
  static final int SIZE = Integer.parseInt(System.getProperty("size", "256"));
  
  public static void main(String[] args) throws Exception {
    Message.MessageData messageData = ClientBrokerStart.createMessageGo("10010001", "43.3", "125.5").build();
    sendRequest(messageData);
  }
  
  public static void sendRequest(Message.MessageData messageData) {
    NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
    try {
      Bootstrap b = new Bootstrap();
      ((Bootstrap)((Bootstrap)((Bootstrap)((Bootstrap)b.group((EventLoopGroup)nioEventLoopGroup))
        .channel(NioSocketChannel.class))
        .option(ChannelOption.TCP_NODELAY, Boolean.valueOf(true)))
        .option(ChannelOption.SO_KEEPALIVE, Boolean.valueOf(true)))
        .handler((ChannelHandler)new Object());
      ChannelFuture future = b.connect(HOST, PORT).sync();
      future.channel().writeAndFlush(messageData);
      long endTime = System.currentTimeMillis();
      future.channel().closeFuture().sync();
      AttributeKey<String> key = AttributeKey.valueOf("ServerData");
      Object object = future.channel().attr(key).get();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      nioEventLoopGroup.shutdownGracefully();
    } 
  }
}
