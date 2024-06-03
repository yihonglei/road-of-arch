package com.jpeony.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yihonglei
 */
public class NIOServer {
    private static Selector selector;

    public static void main(String[] args) throws IOException {
        // 1、打开 ServerSocketChannel，用于监听客户端的连接，它是所有客户端连接的父通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 2、绑定监听端口，设置客户端连接方式为非阻塞模式
        serverSocketChannel.socket().bind(new InetSocketAddress(8989));
        serverSocketChannel.configureBlocking(false);

        // 3、创建 Selector，启动线程
        selector = Selector.open();

        // 4、将 ServerSocketChannel 注册到 Selector，监听 SelectionKey.OP_ACCEPT
        SelectionKey sk = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // sk.attach(new Acceptor());

        // 5、轮询就绪的 key
        // 多路复用器在线程 run 方法的无限循环体内轮询准备就绪的 Key，通常情况下需要设置一个退出状态检测位，用于优雅停机
        while (true) {
            // 当注册事件到达时，方法返回，否则该方法会一直阻塞
            selector.select();
            Set<SelectionKey> selected = selector.selectedKeys();
            Iterator<SelectionKey> it = selected.iterator();
            while (it.hasNext()) {
                dispatch((SelectionKey) it.next());
                selected.clear();
            }
        }
    }

    private static void dispatch(SelectionKey key) throws IOException {
        // 6、handleAccept 处理新的客户端接入
        if (key.isAcceptable()) {
            handleAccept(key);
        } else if (key.isReadable()) {
            // 8、handleRead 异步读请求
            handleRead(key);
        }
    }


    private static void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = server.accept();
        socketChannel.configureBlocking(false);

        String msg = "Hello Client";
        socketChannel.write(ByteBuffer.wrap(msg.getBytes()));

        // 9、将新接入的客户端连接注册到多路复用器，监听读操作位，用来读取客户端发送的网络消息
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();

        ByteBuffer buffer = ByteBuffer.allocate(128);
        // 10、异步读取客户端请求消息到服务端缓冲区
        channel.read(buffer);

        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("server received msg from client：" + msg);
    }
}