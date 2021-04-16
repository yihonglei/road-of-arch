package com.jpeony.netty.mq.client;

import com.jpeony.netty.mq.common.NettyDecoder;
import com.jpeony.netty.mq.common.NettyEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @author yihonglei
 */
public class NettyClientChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new IdleStateHandler(0, 10, 0))
                .addLast("encoder", new NettyEncoder())
                .addLast("decoder", new NettyDecoder())
                .addLast(new HeartbeatHandler());
    }
}
