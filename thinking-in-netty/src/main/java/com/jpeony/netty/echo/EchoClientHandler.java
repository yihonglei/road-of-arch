package com.jpeony.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * 客户端业务逻辑处理
 *
 * @author yihonglei
 */
@ChannelHandler.Sharable // 标记该类的实例可以被多个 Channel 共享
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    /**
     * 连接服务器成功之后被调用
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        String data = "Hello Server!";
        ctx.writeAndFlush(Unpooled.copiedBuffer(data, CharsetUtil.UTF_8));
    }

    /**
     * 从服务器接收到消息时被调用
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf in) {
        System.out.println("客户端接收到消息：" + in.toString(CharsetUtil.UTF_8));
    }

    /**
     * 在处理过程中抛异常时调用
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
