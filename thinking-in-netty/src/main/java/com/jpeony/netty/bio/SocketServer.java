package com.jpeony.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1、bio 单线程时接受客户端请求慢；
 * 2、bio 多线程时并发量高会创建大量线程，系统线程开启数量有限，系统资源不够崩掉，
 * 你可以开线程池处理，但是当访问了剧增时，处理不了成千上万的并发量；
 * 3、bio 支撑不了高并发访问；
 *
 * @author yihonglei
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8989);
        System.out.println("Listening for connection on port 8989 ......");
        while (true) {
            // 阻塞方法，等待客户端连接
            final Socket client = server.accept();
//            handler(client);
            // 可以使用多线程处理，缺陷就是并发量高时会创建大量线程，系统线程开启数量有限，系统资源不够崩掉
            new Thread(() -> {
                try {
                    handler(client);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static void handler(Socket client) throws IOException {
        byte[] bytes = new byte[1024];

        // Read request from the client socket
        int read = client.getInputStream().read(bytes);
        if (read != -1) {
            System.out.println("接收到客户端的数据：" + new String(bytes, 0, read));
        }
        // Send response to the client
        client.getOutputStream().write("Hello Client".getBytes());
        client.getOutputStream().flush();
    }
}