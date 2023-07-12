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
        // 工作线程组，用于接收客户端的连接，但是不做任何具体业务处理，像老鸨一样负责接待客户，不具体服务客户
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // 工作线程组，老鸨线程组会把任务丢给他，让工作线程组去服务客户
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 创建 ServerBootstrap 用于配置 Server 相关参数，并启动 Server
            ServerBootstrap b = new ServerBootstrap();

            // 链式调用
            // 配置 parentGroup 和 childGroup
            b.group(bossGroup, workerGroup)
                    // 配置 Server 通道
                    .channel(NioServerSocketChannel.class)
                    // 使用指定的端口设置套接字地址
                    .localAddress(new InetSocketAddress(port))
                    // 配置通道的 ChannelPipeline
                    .childHandler(new EchoServerHandler());

            // 绑定端口，并启动 Server，同时设置启动方式为同步
            ChannelFuture f = b.bind().sync();

            System.out.println("启动成功，在地址[" + f.channel().localAddress() + "]上等待客户端请求......");

            // 等待服务端监听端口关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        // 设置端口值
        new EchoServer(9999).start();
    }
}
