package com.jpeony.netty.mq.client;

import com.jpeony.netty.mq.common.Command;
import com.jpeony.netty.mq.common.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.time.LocalTime;

/**
 * @author yihonglei
 */
public class HeartbeatHandler extends SimpleChannelInboundHandler<Message> {

    public static final String CLIENT_ID = System.getProperty("spring.netty.clientId", "101");

    private int unRecPongTimes = 0;

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String idleType = "";
            if (event.state() == IdleState.READER_IDLE) {
                idleType = "read idle";
            } else if (event.state() == IdleState.WRITER_IDLE) {
                idleType = "write idle";
            } else if (event.state() == IdleState.ALL_IDLE) {
                idleType = "all idle";
            }
            System.out.println("netty client idleType " + idleType);
            if (this.unRecPongTimes < 3) {
                sendPingMsg(ctx);
                unRecPongTimes++;
            } else {
                ctx.channel().close();
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    private void sendPingMsg(ChannelHandlerContext ctx) {
        System.out.println("【客户端】10 秒了，需要发送消息给服务端保持心跳" + LocalTime.now());
        Message pingDataMsg = new Message();
        pingDataMsg.setClientId(CLIENT_ID);
        pingDataMsg.setCmd(Command.PING);
        pingDataMsg.setData("heartbeat");
        ctx.writeAndFlush(pingDataMsg);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        System.out.println("【客户端】收到从服务端发来的消息" + msg);

        switch (msg.getCmd()) {
            case Command.PONG:
                System.out.println("【客户端】接收到服务端 pong 响应数据");
                unRecPongTimes = 0;
                break;
            case Command.UPLOAD_DATA:
                System.out.println("【客户端】接收到服务端 upload_data 上传数据");
                // TODO 做业务
                break;
            case Command.PUSH_DATA_BACK:
                System.out.println("【客户端】接收到服务端 push_data_back 响应数据");
                break;
            default:
                break;
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("捕获的异常：" + cause.getMessage());
        ctx.channel().close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("检测到心跳服务器断开！！！！准备新建连接");
        // 断线重连
        NettyClientManager producer = NettyClientManager.getInstance();

        Message message = new Message();
        message.setClientId(CLIENT_ID);
        message.setCmd(Command.RE_CONNECT);
        message.setData("【客户端】客户端断线重新连接服务端");
        producer.send(message);
    }
}
