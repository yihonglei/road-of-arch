package com.jpeony.ipc.tcp.server;

import com.jpeony.netty.client.MessageDataBuilder;
import com.jpeony.netty.client.PlatformChannelCache;
import com.jpeony.protobuf.Message;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("serverBrokerHandler")
@Sharable
public class ServerBrokerHandler extends ChannelInboundHandlerAdapter {
    public Logger log = LoggerFactory.getLogger(getClass());

    private final AttributeKey<String> clientInfo = AttributeKey.valueOf("clientInfo");

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message.MessageData messageData = (Message.MessageData) msg;
        this.log.info("brokerserver channelRead 开始了，数据类型是 {}", messageData.getType());
        Channel channel = PlatformChannelCache.getCache();
        channel.writeAndFlush(messageData);
        waitResAndSendToIpc(ctx);
    }

    private void waitResAndSendToIpc(ChannelHandlerContext ctx) {
        int i = 1;
        int tryCount = 6;
        int tryTime = 200;
        while (true) {
            Message.MessageData messageDataRes = (Message.MessageData) MessageDataBuilder.serverResponse;
            if (i > tryCount) {
                this.log.info("无法获取到云端server返回值！！！！！！！！！！");
                break;
            }
            if (messageDataRes != null) {
                ctx.channel().writeAndFlush(messageDataRes);
                MessageDataBuilder.serverResponse = null;
                break;
            }
            try {
                Thread.sleep(tryTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.log.info("等待云端server返回值{}ms.........", Integer.valueOf(i * tryTime));
            i++;
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        this.log.error("客户端断开连接， ctx是" + ctx + "----错误详情是=====" + cause.getMessage());
    }
}
