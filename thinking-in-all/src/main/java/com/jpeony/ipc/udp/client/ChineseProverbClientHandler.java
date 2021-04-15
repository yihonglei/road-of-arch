package com.jpeony.ipc.udp.client;

import com.google.protobuf.ServiceException;
import com.jpeony.netty.client.PlatformChannelCache;
import com.jpeony.protobuf.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChineseProverbClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    public Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        byte[] array;
        ByteBuf bytebuf = (ByteBuf) packet.content();
        int length = bytebuf.readableBytes();
        if (bytebuf.hasArray()) {
            array = bytebuf.array();
        } else {
            array = new byte[length];
            bytebuf.getBytes(bytebuf.readerIndex(), array, 0, length);
        }
        Message.MessageData recvMsg = Message.MessageData.parseFrom(array);
        this.logger.info("UDP client channelRead0 recvMsg={}", recvMsg);
        if (recvMsg.getType() == Message.MessageData.DataType.MessageGeneralBiz) {
            Message.MessageGeneralBiz messageGeneralBiz = recvMsg.getMessageGeneralBiz();
            Channel channel = PlatformChannelCache.getCache();
            if (channel != null) {
                this.logger.info("UDP client 接收服务端数据 messageBase={}, 开始向云端发送数据", messageGeneralBiz);
                channel.writeAndFlush(recvMsg);
            } else {
                throw new ServiceException("存储的云端channel不能为空");
            }
        } else {
            this.logger.info("IPC服务端数据类型未知...............{}", recvMsg.getType());
        }
        ctx.close();
    }
}
