package com.jpeony.ipc.udp.server;

import com.google.protobuf.ServiceException;
import com.jpeony.netty.client.MessageDataBuilder;
import com.jpeony.netty.client.PlatformChannelCache;
import com.jpeony.protobuf.Message;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChineseProverbServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    public Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        byte[] array;
        this.logger.info("ChineseProverbServerHandler channelRead0开始..........packet={}", packet);
        ByteBuf bytebuf = (ByteBuf) packet.content();
        int length = bytebuf.readableBytes();
        if (bytebuf.hasArray()) {
            array = bytebuf.array();
        } else {
            array = new byte[length];
            bytebuf.getBytes(bytebuf.readerIndex(), array, 0, length);
        }
        this.logger.info("packet length:{}, 内容:{}", Integer.valueOf(array.length), new String(array));
        Message.MessageData reqMsg = Message.MessageData.parseFrom(array);
        this.logger.info("MessageData解析成功，reqMsg={}", reqMsg);
        Channel channel = PlatformChannelCache.getCache();
        if (channel != null) {
            this.logger.info("UDP server开始向云端server发送数据..........reqMsg={}", reqMsg);
            channel.writeAndFlush(reqMsg);
            if (reqMsg.getType() == Message.MessageData.DataType.MessageArrive) {
                waitResAndSendToIpc(ctx, packet);
            }
        } else {
            throw new ServiceException("缓存的云端channel不能为空");
        }
    }

    private void waitResAndSendToIpc(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        int i = 1;
        int tryCount = 10;
        int tryTime = 200;
        while (true) {
            Message.MessageData messageDataRes = (Message.MessageData) MessageDataBuilder.serverResponse;
            if (i > tryCount) {
                this.logger.info("无法获取到云端server返回值!!!!!!!!!");
                break;
            }
            if (messageDataRes != null) {
                this.logger.info("开始向IPC发送信息............responseMsg={}", messageDataRes);
                DatagramPacket reply = new DatagramPacket(Unpooled.wrappedBuffer(messageDataRes.toByteArray()), (InetSocketAddress) packet.sender());
                ctx.writeAndFlush(reply).sync();
                this.logger.info("开始向IPC发送信息完成了.................");
                MessageDataBuilder.serverResponse = null;
                break;
            }
            try {
                Thread.sleep(tryTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.logger.info("等待云端server返回值{}ms.........", Integer.valueOf(i * tryTime));
            i++;
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.logger.info("ChineseProverbServerHandler channelActive进入...........");
    }
}
