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
@ChannelHandler.Sharable //注解@ChannelHandler.Sharable表示一个ChannelHandler可以被多个Channel安全地共享。
public class EchoServerHandler extends SimpleChannelInboundHandler {

    /**
     * 每个传入的消息都要调用该方法
     */
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        // 将客户端发送过来的消息打印到控制台
//        ByteBuf in = (ByteBuf) msg;
//        System.out.println("server received msg from client：" + in.toString(CharsetUtil.UTF_8));
//
//        // 写一条消息响应给客户端
//        ByteBuf responseMsg = Unpooled.wrappedBuffer(new String("Hello Client!").getBytes());
//        ctx.write(responseMsg);
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        System.out.println("server received msg from client：" + in.toString(CharsetUtil.UTF_8));
    }

    /**
     * 通知ChannelInboundHandler最后一次对channelRead()的调用时当前批量读取中的最后一条消息
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        // 将未决消息冲刷到远程节点，并且关闭该Channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
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
