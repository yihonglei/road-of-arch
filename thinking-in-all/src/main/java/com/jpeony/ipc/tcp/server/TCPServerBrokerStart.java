package com.jpeony.ipc.tcp.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import java.net.InetSocketAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class TCPServerBrokerStart {
  public Logger logger = LoggerFactory.getLogger(getClass());
  
  @Autowired
  @Qualifier("serverBootstrap")
  private ServerBootstrap serverBootstrap;
  
  @Autowired
  @Qualifier("tcpSocketAddress")
  private InetSocketAddress tcpIpAndPort;
  
  private Channel serverChannel;
  
  @Async
  public void start() {
    try {
      ChannelFuture f = this.serverBootstrap.bind(this.tcpIpAndPort).sync();
      if (f.isSuccess()) {
        this.logger.info("server start---------------on port:" + this.tcpIpAndPort.toString());
      }
      this.serverChannel = f.channel().closeFuture().sync().channel();
    } catch (InterruptedException e) {
      e.printStackTrace();
      this.logger.info("监听端口："+ this.tcpIpAndPort.toString() + " 出现异常", e);
    } finally {
      this.logger.info("server close---------------");
      this.serverBootstrap.group().shutdownGracefully();
      this.serverBootstrap.childGroup().shutdownGracefully();
    } 
  }
  
  public void stop() throws Exception {
    this.serverChannel.close();
    this.serverChannel.parent().close();
  }
  
  public ServerBootstrap getServerBootstrap() {
    return this.serverBootstrap;
  }
  
  public void setServerBootstrap(ServerBootstrap serverBootstrap) {
    this.serverBootstrap = serverBootstrap;
  }
  
  public InetSocketAddress getTcpPort() {
    return this.tcpIpAndPort;
  }
  
  public void setTcpPort(InetSocketAddress tcpPort) {
    this.tcpIpAndPort = tcpPort;
  }
}
