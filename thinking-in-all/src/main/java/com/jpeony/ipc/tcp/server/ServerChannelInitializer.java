package com.jpeony.ipc.tcp.server;

import com.google.protobuf.MessageLite;
import com.jpeony.protobuf.Message;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("serverChannelInitializer")
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
  @Autowired
  @Qualifier("serverBrokerHandler")
  private ChannelInboundHandlerAdapter serverBrokerHandler;

  @Override
  protected void initChannel(SocketChannel socketChannel) throws Exception {
    ChannelPipeline p = socketChannel.pipeline();
    p.addLast(new ChannelHandler[] { (ChannelHandler)new ProtobufVarint32FrameDecoder() });
    p.addLast(new ChannelHandler[] { (ChannelHandler)new ProtobufDecoder((MessageLite) Message.MessageData.getDefaultInstance()) });
    p.addLast(new ChannelHandler[] { (ChannelHandler)new ProtobufVarint32LengthFieldPrepender() });
    p.addLast(new ChannelHandler[] { (ChannelHandler)new ProtobufEncoder() });
    p.addLast("serverBrokerHandler", (ChannelHandler)this.serverBrokerHandler);
  }
}
