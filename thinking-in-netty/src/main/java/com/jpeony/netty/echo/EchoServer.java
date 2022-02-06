package com.jpeony.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * 一 Netty Server启动流程
 * 1、设置服务端 ServerBootStrap 启动参数
 * group() 方法分配一个 NioEventLoopGroup 实例以进行事件处理，如接受新连接以及读/写数据；
 * channel() 设置通道类型；
 * localAddress() 指定服务器绑定的本地的 InetSocketAddress；
 * childHandler() 添加一个 EchoServerHandler 到 Channel 的 ChannelPipeline；
 * 2、调用 ServerBootStrap.bind() 方法启动服务端
 * 调用 ServerBootStrap.bind() 方法启动服务端，bind() 方法会在 group 中注册 NioServerSocketChannel，
 * 监听客户端的连接请求会创建一个 NioServerSocketChannel 实例，并将其在 group 中进行注册；
 *
 * @author yihonglei
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    /**
     * 服务器端启动方法
     */
    private void start() throws Exception {
        /*
         * 创建 EventLoopGroup
         * 1、bossGroup 线程组实际上是 Acceptor 线程池，负责处理客户端的 TCP 连接请求，如果系统只有一个服务端端口需要监听，
         * 则建议 bossGroup 线程组线程数设置为 1；
         * 2、workerGroup 是真正负责 I/O 读写操作的线程组，通过 ServerBootstrap 的 group 方法进行设置，用于后续的 Channel 绑定。
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 创建 ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();

            // 指定 EventLoopGroup 以处理服务端事件，需要适用于 NIO 的实现。
            b.group(bossGroup, workerGroup)
                    // 指定所使用的 NIO 传输 Channel
                    .channel(NioServerSocketChannel.class)
                    // 使用指定的端口设置套接字地址
                    .localAddress(new InetSocketAddress(port))
                    // 添加一个 EchoServerHandler 到 Channel 的 ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            // EchoServerHandler 被标注为 @Shareable，所以我们可以总是使用同样的实例
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });

            // 异步地绑定服务器，调用 sync() 方法阻塞直到绑定完成
            ChannelFuture f = b.bind().sync();

            // 绑定 Channel 的 CloseFuture，并且阻塞当前线程直到它完成
            f.channel().closeFuture().sync();
        } finally {
            // 关闭 EventLoopGroup 并且释放所有的资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        // 设置端口值
        new EchoServer(9999).start();
    }
}
