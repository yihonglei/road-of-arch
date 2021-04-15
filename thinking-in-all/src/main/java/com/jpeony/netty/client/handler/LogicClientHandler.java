package com.jpeony.netty.client.handler;

import com.jpeony.netty.client.MessageDataBuilder;
import com.jpeony.netty.client.PlatformChannelCache;
import com.jpeony.protobuf.Command;
import com.jpeony.protobuf.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogicClientHandler extends SimpleChannelInboundHandler<Message> {
    public Logger log = LoggerFactory.getLogger(getClass());

    private static final String CLIENTID = HeartHandler.CLIENTID;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.log.info("{}注册成功，channel 是：{}", CLIENTID, ctx.channel().toString());
        Message.MessageData.Builder authMsg = MessageDataBuilder.createData(CLIENTID, Command.CommandType.AUTH, "This is auth data");
        PlatformChannelCache.setCache(ctx.channel());
        ctx.writeAndFlush(authMsg.build());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        this.log.debug("连接断开");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
    }
}
