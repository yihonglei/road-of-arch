package com.jpeony.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * 1、初始化客户端，将创建一个 Bootstrap 实例；
 * 2、为事件处理分配一个 NioEventLoopGroup 实例，其中事件处理包括创建新的连接以及处理入站和出站数据；
 * 3、为服务器连接创建一个 InetSocketAddress 实例；
 * 4、当连接被建立时，一个 EchoClientHandler 实例会被安装到 ChannelPipeline 中；
 * 5、在一切都设置完成后，调用 Bootstrap.connect() 方法连接到远程节点；
 *
 * @author yihonglei
 */
public class EchoClient {
    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * 客户端启动方法
     */
    private void start() throws InterruptedException {
        // 创建 EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            // 创建 Bootstrap 用于配置 Client 相关参数
            Bootstrap b = new Bootstrap();

            // 链式调用
            // 设置 group
            b.group(group)
                    // 配置 Client 通道
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    // 设置连接超时时间
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                    // 设置服务器的 InetSocketAddress
                    .remoteAddress(new InetSocketAddress(host, port))
                    // 配置通道的 ChannelPipeline
                    .handler(new EchoClientHandler());

            // 发起异步连接操作
            ChannelFuture f = b.connect().sync();

            // 等待客户端链路关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放线程池资源
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoClient("127.0.0.1", 9999).start();

        Thread.sleep(100000);
    }
}
