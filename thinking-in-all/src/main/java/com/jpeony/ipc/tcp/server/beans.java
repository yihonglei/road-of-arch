package com.jpeony.ipc.tcp.server;

import com.jpeony.common.SpringBeanFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class beans {
  @Autowired
  @Qualifier("serverChannelInitializer")
  private ServerChannelInitializer serverChannelInitializer;
  
  @Value("${tcp.host}")
  private String host;
  
  @Value("${tcp.port}")
  private int tcpPort;
  
  @Value("${boss.thread.count}")
  private int bossCount;
  
  @Value("${worker.thread.count}")
  private int workerCount;
  
  @Value("${so.keepalive}")
  private boolean keepAlive;
  
  @Value("${so.backlog}")
  private int backlog;
  
  @Bean(name = {"serverBootstrap"})
  public ServerBootstrap bootstrap() {
    ServerBootstrap b = new ServerBootstrap();
    ((ServerBootstrap)((ServerBootstrap)b.group((EventLoopGroup)bossGroup(), (EventLoopGroup)workerGroup())
      .channel(NioServerSocketChannel.class))
      .handler((ChannelHandler)new LoggingHandler(LogLevel.DEBUG)))
      .childHandler((ChannelHandler)this.serverChannelInitializer);
    Map<ChannelOption<?>, Object> tcpChannelOptions = tcpChannelOptions();
    Set<ChannelOption<?>> keySet = tcpChannelOptions.keySet();
    for (ChannelOption<?> option : keySet) {
      b.option(option, tcpChannelOptions.get(option));
    }
    return b;
  }
  
  @Bean(name = {"tcpChannelOptions"})
  public Map<ChannelOption<?>, Object> tcpChannelOptions() {
    Map<ChannelOption<?>, Object> options = new HashMap<>();
    options.put(ChannelOption.SO_KEEPALIVE, Boolean.valueOf(this.keepAlive));
    options.put(ChannelOption.SO_BACKLOG, Integer.valueOf(this.backlog));
    options.put(ChannelOption.TCP_NODELAY, Boolean.valueOf(true));
    return options;
  }
  
  @Bean(name = {"bossGroup"}, destroyMethod = "shutdownGracefully")
  public NioEventLoopGroup bossGroup() {
    return new NioEventLoopGroup(this.bossCount);
  }
  
  @Bean(name = {"workerGroup"}, destroyMethod = "shutdownGracefully")
  public NioEventLoopGroup workerGroup() {
    return new NioEventLoopGroup(this.workerCount);
  }
  
  @Bean(name = {"tcpSocketAddress"})
  public InetSocketAddress tcpPort() {
    return new InetSocketAddress(this.host, this.tcpPort);
  }
  
  @Bean
  @Lazy(false)
  public SpringBeanFactory springBeanFactory() {
    return new SpringBeanFactory();
  }
}
