package com.jpeony.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;


/**
 * 服务端业务逻辑处理。
 *
 * @author yihonglei
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 每个传入的消息都要调用该方法
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        System.out.println("服务器接收到消息：" + in.toString(CharsetUtil.UTF_8));

        ByteBuf responseMsg = Unpooled.wrappedBuffer(new String("Hello Client!").getBytes());
        ctx.write(responseMsg);
    }

    /**
     * 通知 ChannelInboundHandler 最后一次对 channelRead() 的调用时当前批量读取中的最后一条消息
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        // 将读完的消息写入到缓冲区
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }

    /**
     * 在读取操作期间，有异常抛出时会调用
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
