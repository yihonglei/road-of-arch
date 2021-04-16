package com.jpeony.netty.mq.common;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @author yihonglei
 */
public class NettyDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) throws Exception {
        String data = byteBuf.toString(CharsetUtil.UTF_8);
        Message message = JSONObject.parseObject(data, Message.class);

        out.add(message);
    }
}
