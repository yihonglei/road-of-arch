package com.jpeony.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yihonglei
 */
public class NIOClient {
    private static Selector selector;

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);

        channel.connect(new InetSocketAddress("127.0.0.1", 8989));

        selector = Selector.open();
        channel.register(selector, SelectionKey.OP_CONNECT);

        while (true) {
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
        if (key.isConnectable()) {
            handleConnect(key);
        } else if (key.isReadable()) {
            handleRead(key);
        }
    }

    private static void handleConnect(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        if (channel.isConnectionPending()) {
            channel.finishConnect();
        }
        channel.configureBlocking(false);

        String msg = "Hello server";
        channel.write(ByteBuffer.wrap(msg.getBytes()));

        channel.register(selector, SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();

        ByteBuffer buffer = ByteBuffer.allocate(128);
        channel.read(buffer);

        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("client received msg from server：" + msg);
    }
}