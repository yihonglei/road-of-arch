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
 * 1、设置服务端ServerBootStrap启动参数
 * <p>
 * group()方法分配一个NioEventLoopGroup实例以进行事件处理，如接受新连接以及读/写数据；
 * <p>
 * channel()设置通道类型；
 * <p>
 * localAddress()指定服务器绑定的本地的InetSocketAddress；
 * <p>
 * childHandler()添加一个EchoServerHandler到Channel的ChannelPipeline；
 * 2、调用ServerBootStrap.bind()方法启动服务端
 * 调用ServerBootStrap.bind()方法启动服务端，bind方法会在group中注册NioServerScoketChannel，
 * 监听客户端的连接请求会创建一个NioServerSocketChannel实例，并将其在group中进行注册；
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
         * 创建EventLoopGroup
         * 1、bossGroup线程组实际上是Acceptor线程池，负责处理客户端的TCP连接请求，如果系统只有一个服务端端口需要监听，
         * 则建议bossGroup线程组线程数设置为1；
         * 2、workerGroup是真正负责I/O读写操作的线程组，通过ServerBootstrap的group方法进行设置，用于后续的Channel绑定。
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 创建ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();

            // 指定EventLoopGroup以处理服务端事件，需要适用于NIO的实现。
            b.group(bossGroup, workerGroup)
                    // 指定所使用的NIO传输Channel
                    .channel(NioServerSocketChannel.class)
                    // 使用指定的端口设置套接字地址
                    .localAddress(new InetSocketAddress(port))
                    // 添加一个EchoServerHandler到Channel的ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            // EchoServerHandler被标注为@Shareable，所以我们可以总是使用同样的实例
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });

            // 异步地绑定服务器，调用sync()方法阻塞直到绑定完成
            ChannelFuture f = b.bind().sync();

            // 绑定Channel的CloseFuture，并且阻塞当前线程直到它完成
//            f.channel().closeFuture().sync();
        } finally {
            // 关闭EventLoopGroup并且释放所有的资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        // 设置端口值
        new EchoServer(9999).start();
    }
}
