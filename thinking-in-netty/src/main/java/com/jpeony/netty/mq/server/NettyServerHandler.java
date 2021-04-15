package com.jpeony.netty.mq.server;

import com.jpeony.netty.mq.common.ChannelCache;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.springframework.stereotype.Component;

/**
 * @author yihonglei
 */
@Component
public class NettyServerHandler extends SimpleChannelInboundHandler {
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端掉线......");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        System.out.println("server received msg from client：" + in.toString(CharsetUtil.UTF_8));
        String message = in.toString(CharsetUtil.UTF_8);

        /* 心跳数据是不发送数据 */
        if (!message.contains("heartbeat")) {
            String responseData = "Hello Client!";
            ctx.writeAndFlush(Unpooled.copiedBuffer(responseData, CharsetUtil.UTF_8));
            ChannelCache.put("101", ctx.channel());
        }
    }

    /**
     * 通知ChannelInboundHandler最后一次对channelRead()的调用时当前批量读取中的最后一条消息
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        // 将未决消息冲刷到远程节点，并且关闭该Channel
//        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
    }

    /**
     * 在读取操作期间，有异常抛出时会调用
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 打印异常栈跟踪信息
        cause.printStackTrace();

        // 关闭该Channel
        ctx.close();
    }
}
