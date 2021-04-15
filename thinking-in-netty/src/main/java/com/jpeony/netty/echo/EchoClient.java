package com.jpeony.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * 1、初始化客户端，将创建一个Bootstrap实例；
 * 2、为事件处理分配一个NioEventLoopGroup实例，其中事件处理包括创建新的连接以及处理入站和出站数据；
 * 3、为服务器连接创建一个InetSocketAddress实例；
 * 4、当连接被建立时，一个EchoClientHandler实例会被安装到ChannelPipeline中；
 * 5、在一切都设置完成后，调用Bootstrap.connect()方法连接到远程节点；
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
        // 创建EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            // 创建Bootstrap
            Bootstrap b = new Bootstrap();

            // 指定EventLoopGroup以处理客户端事件，需要适用于NIO的实现。
            b.group(group)
                    // 适用于NIO传输的Channel类型
                    .channel(NioSocketChannel.class)
                    // 设置服务器的InetSocketAddress
                    .remoteAddress(new InetSocketAddress(host, port))
                    // 在创建Channel时，向ChannelPipeline中添加一个EchoClientHandler实例
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });

            // 连接到远程节点，阻塞等待知道连接完成
            ChannelFuture f = b.connect().sync();

            // 阻塞，直到Channel关闭
            f.channel().closeFuture().sync();
        } finally {
            // 关闭EventLoopGroup并且释放所有的资源
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoClient("127.0.0.1", 9999).start();

        Thread.sleep(100000);
    }
}
