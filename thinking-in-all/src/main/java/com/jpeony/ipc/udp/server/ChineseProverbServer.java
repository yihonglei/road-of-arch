package com.jpeony.ipc.udp.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@EnableAsync
@Component
public class ChineseProverbServer {
    private int port = Integer.valueOf(System.getProperty("tcp.port", "18888")).intValue();

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Async
    public void run() throws Exception {
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            ((Bootstrap) ((Bootstrap) ((Bootstrap) ((Bootstrap) ((Bootstrap) b.group((EventLoopGroup) nioEventLoopGroup))
                    .channel(NioDatagramChannel.class))
                    .option(ChannelOption.SO_BROADCAST, Boolean.valueOf(true)))
                    .option(ChannelOption.SO_RCVBUF, Integer.valueOf(20971520)))
                    .option(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(196608)))
                    .handler((ChannelHandler) new ChineseProverbServerHandler());
            b.bind(this.port).sync().channel().closeFuture().await();
        } catch (Exception e) {
            this.logger.info("服务启动失败");
            e.printStackTrace();
        } finally {
            nioEventLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 18888;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]).intValue();
        }
        (new ChineseProverbServer()).run();
    }
}
