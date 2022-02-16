package com.jpeony.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1、bio 单线程时接受客户端请求慢；
 * 2、bio 多线程时并发量高会创建大量线程，系统线程开启数量有限，系统资源不够崩掉，
 * 你可以开线程池处理，但是当访问量剧增时，处理不了成千上万的并发量；
 * 因为阻塞 IO 会由于频繁的 wait 导致 IO 线程经常性的阻塞，线程无法进行高效的工作，IO 处理能力自然下降。
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
            // handler(client);
            // 可以使用多线程处理，缺陷就是并发量高时会创建大量线程，系统线程开启数量有限，系统资源不够崩掉，
            // 也可以优化为线程池，但是还是解决不了大流量访问的问题，因为线程还是一直要占用到响应结束，空闲时间不能处理业务。
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