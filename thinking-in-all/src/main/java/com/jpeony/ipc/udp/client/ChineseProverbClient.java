package com.jpeony.ipc.udp.client;

import com.jpeony.netty.client.MessageDataBuilder;
import com.jpeony.protobuf.Command;
import com.jpeony.protobuf.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import java.net.InetSocketAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChineseProverbClient {
  private String ip = System.getProperty("ipc.host", "127.0.0.1");
  
  private int port = Integer.valueOf(System.getProperty("ipc.port", "17777")).intValue();
  
  public Logger logger = LoggerFactory.getLogger(getClass());
  
  public void run(Message.MessageData originmsg) throws Exception {
    NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
    try {
      Bootstrap b = new Bootstrap();
      ((Bootstrap)((Bootstrap)((Bootstrap)b.group((EventLoopGroup)nioEventLoopGroup))
        .channel(NioDatagramChannel.class))
        .option(ChannelOption.SO_BROADCAST, Boolean.valueOf(true)))
        .handler((ChannelHandler)new ChineseProverbClientHandler());
      Channel ch = b.bind(0).sync().channel();
      DatagramPacket msg = new DatagramPacket(Unpooled.wrappedBuffer(originmsg.toByteArray()), new InetSocketAddress(this.ip, this.port));
      this.logger.info("UDP client 开始向IPC server发送请求......msg={}", msg);
      ch.writeAndFlush(msg).sync();
      if (!ch.closeFuture().await(2000L)) {
        this.logger.info("查询超时！");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      nioEventLoopGroup.shutdownGracefully();
    } 
  }
  
  public static void main(String[] args) throws Exception {
    Message.MessageData msg = MessageDataBuilder.createGoData("10010001", Command.CommandType.PUSH_DATA, "143.11111,45.6666").build();
    (new ChineseProverbClient()).run(msg);
  }
}
