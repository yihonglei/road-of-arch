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
        // 1、打开 ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        // 2、绑定监听地址 InetSocketAddress
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8989));

        // 3、创建 Selector，启动线程
        selector = Selector.open();

        // 4、将 ServerSocketChannel 注册到 Selector，监听 SelectionKey.OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 5、轮询就绪的 key
        while (true) {
            // 当注册事件到达时，方法返回，否则该方法会一直阻塞
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                // 6、handleAccept 处理新的客户端接入
                if (key.isAcceptable()) {
                    handleAccept(key);
                } else if (key.isReadable()) {
                    // 8、handleRead 异步读请求
                    handleRead(key);
                }
            }
        }
    }

    private static void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = server.accept();
        socketChannel.configureBlocking(false);

        String msg = "Hello Client";
        socketChannel.write(ByteBuffer.wrap(msg.getBytes()));

        // 7、向 Selector 注册监听读操作
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();

        ByteBuffer buffer = ByteBuffer.allocate(128);
        channel.read(buffer);

        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("server received msg from client：" + msg);
    }
}