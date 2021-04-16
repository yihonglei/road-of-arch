package com.jpeony.netty.mq.server;

import com.jpeony.netty.mq.common.ChannelCache;
import com.jpeony.netty.mq.common.Command;
import com.jpeony.netty.mq.common.Message;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author yihonglei
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<Message> {

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("【服务端】客户端掉线......");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        System.out.println("【服务端】收到从客户端发来的消息：" + msg);

        switch (msg.getCmd()) {
            case Command.PING:
                System.out.println("【服务端】接收到客户端 ping");
                // 响应客户端
                Message pongDataMsg = new Message();
                pongDataMsg.setClientId(msg.getClientId());
                pongDataMsg.setCmd(Command.PONG);
                pongDataMsg.setData("老铁，服务端还活着");
                ctx.writeAndFlush(pongDataMsg);
                break;
            case Command.PUSH_DATA:
                System.out.println("【服务端】接收到客户端 push_data 推送数据");
                // TODO 做业务

                Message pushDataBackMsg = new Message();
                pushDataBackMsg.setClientId(msg.getClientId());
                pushDataBackMsg.setCmd(Command.PUSH_DATA_BACK);
                pushDataBackMsg.setData("【服务端】已经收到客户端发来的数据");
                ctx.writeAndFlush(pushDataBackMsg);

                // 连接通道加入缓存
                ChannelCache.put("101", ctx.channel());
                break;
            default:
                break;
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();

        ctx.close();
    }
}
