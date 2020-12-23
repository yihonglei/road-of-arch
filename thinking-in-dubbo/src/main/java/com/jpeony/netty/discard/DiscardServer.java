package com.jpeony.netty.discard;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Discards any incoming data.
 *
 * @author yihonglei
 */
public final class DiscardServer {
    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    private void start() throws InterruptedException {
        /*
         * 创建两个Group，bossGroup处理连接请求，boss接受到连接，将接受的连接注册到worker上，由workerGroup处理业务
         */
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // 创建服务器端的启动对象
            ServerBootstrap b = new ServerBootstrap();
            // 链式编程来配置参数
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline p = socketChannel.pipeline();
                            p.addLast(new DiscardServerHandler());
                        }
                    });

            // 绑定端口，启动服务器
            ChannelFuture f = b.bind(port).sync();

            // 对通道关闭进行监听，closeFuture是异步操作，通过sync方法同步等待通道关闭处理完毕，这里会阻塞等待通道关闭完成
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8089;
        }
        System.out.println("now server listen at : " + port);
        new DiscardServer(port).start();
    }
}
