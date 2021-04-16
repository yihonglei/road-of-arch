package com.jpeony.netty.mq.server;

import com.jpeony.netty.mq.common.NettyDecoder;
import com.jpeony.netty.mq.common.NettyEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author yihonglei
 */
public class NettyServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("encoder", new NettyEncoder())
                .addLast("decoder", new NettyDecoder())
                .addLast(new NettyServerHandler());
    }
}
