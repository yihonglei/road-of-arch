package com.jpeony.ipc.tcp.client;

import com.jpeony.netty.client.PlatformChannelCache;
import com.jpeony.protobuf.Message;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class ClientBrokerHandler extends SimpleChannelInboundHandler<Message.MessageData> {
  public Logger log = LoggerFactory.getLogger(getClass());
  
  private final DateFormat sf = new SimpleDateFormat("HH:mm:ss");
  
  private static final String CLIENTID = System.getProperty("spring.netty.clientId", "10010001");

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, Message.MessageData msgData) throws Exception {
    this.log.info("进入ClientBrokerHandler的channelRead0，{}", msgData.getType());
    if (msgData.getType() == Message.MessageData.DataType.MessageGeneralBiz) {
      Message.MessageGeneralBiz messageGeneralBiz = msgData.getMessageGeneralBiz();
      Channel channel = PlatformChannelCache.getCache();
      this.log.info("开始向云端发送路径:data={}, 设备id={}, {}指令已经执行。", new Object[] { },messageGeneralBiz.getData(), messageGeneralBiz.getClientId(), messageGeneralBiz.getCmd());

      channel.writeAndFlush(msgData);
    } else if (msgData.getType() == Message.MessageData.DataType.MessageBase) {
      Message.MessageBase messageBase = msgData.getMessageBase();
      this.log.info("此处不应该有 {} 类型的数据.......{}", Integer.valueOf(messageBase.getCmd().getNumber()), messageBase.getData());
    } else {
      this.log.info("IPC服务端数据类型未知...........{}", msgData.getType());
    } 
    ctx.close();
  }
  
  public static String get(String key) {
    ClassPathResource classPathResource = new ClassPathResource("application.properties");
    Properties props = null;
    String property = "";
    try {
      props = PropertiesLoaderUtils.loadProperties((Resource)classPathResource);
      property = props.getProperty(key);
    } catch (IOException e) {
      e.printStackTrace();
    } 
    return property;
  }
}
