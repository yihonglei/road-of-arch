package com.jpeony.netty.mq.common;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 将对象编码为 ByteBuf
 *
 * @author yihonglei
 */
@ChannelHandler.Sharable
public class NettyEncoder extends MessageToByteEncoder<Message> {

    @Override
    public void encode(ChannelHandlerContext ctx, Message message, ByteBuf out) throws Exception {
        byte[] bytes = JSONObject.toJSONString(message).getBytes();
        out.writeBytes(bytes);
    }
}
