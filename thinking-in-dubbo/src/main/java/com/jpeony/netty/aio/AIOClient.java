package com.jpeony.netty.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * @author yihonglei
 */
public class AIOClient {

    public static void main(String[] args) throws Exception {
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8989)).get();
        socketChannel.write(ByteBuffer.wrap("Hello Server!".getBytes()));
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Integer len = socketChannel.read(buffer).get();
        if (len != -1) {
            System.out.println("accept message from server：" + new String(buffer.array(), 0, len));
        }
    }
}