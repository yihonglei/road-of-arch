package com.jpeony.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1、bio单线程时接受客户端请求慢；
 * 2、bio多线程时并发量高会创建大量线程，系统线程开启数量有限，系统资源不够崩掉，
 * 你可以开线程池处理，但是当访问了剧增时，处理不了成千上万的并发量；
 * 3、bio支撑不了高并发访问
 *
 * @author yihonglei
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        // 绑定服务端口
        ServerSocket serverSocket = new ServerSocket(8989);
        while (true) {
            System.out.println("等待客户端连接......");
            // 阻塞方法，等待客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("有客户端连接了......");
            // 数据处理
//            handler(socket);
            // 可以使用多线程处理，缺陷就是并发量高时会创建大量线程，系统线程开启数量有限，系统资源不够崩掉
            new Thread(() -> {
                try {
                    handler(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static void handler(Socket socket) throws IOException {
        System.out.println("thread id：" + Thread.currentThread().getId());
        byte[] bytes = new byte[1024];

        System.out.println("准备read......");
        // 接收客户端的数据，阻塞方法，没有数据可读时就阻塞
        int read = socket.getInputStream().read(bytes);
        System.out.println("read完毕!");
        if (read != -1) {
            System.out.println("接收到客户端的数据：" + new String(bytes, 0, read));
            System.out.println("thread id：" + Thread.currentThread().getId());

        }
        // 数据回写客户端
        socket.getOutputStream().write("Hello Client!".getBytes());
        socket.getOutputStream().flush();
        System.out.println("==============================================");
    }
}