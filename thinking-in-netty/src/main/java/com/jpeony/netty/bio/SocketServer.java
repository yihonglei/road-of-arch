package com.jpeony.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1、bio 单线程时接受客户端请求慢；
 * 2、bio 多线程时并发量高会创建大量线程，系统线程开启数量有限，系统资源不够崩掉，
 * 你可以开线程池处理，但是当访问量剧增时，处理不了成千上万的并发量；
 * 因为阻塞 IO 会由于频繁的 wait 导致 IO 线程经常性的阻塞，线程无法进行高效的工作，
 * IO 处理能力自然下降，大量请求依然阻塞。
 * 3、bio 支撑不了高并发访问；
 *
 * @author yihonglei
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(8989);
            System.out.println("Listening for connection on port 8989 ......");
            while (true) {
                Socket socket = server.accept();
                new Thread(new Handler(socket)).start();
            }
        } catch (IOException ex) {
            // ignore
        }
    }

    static class Handler implements Runnable {
        final Socket socket;

        Handler(Socket s) {
            socket = s;
        }

        @Override
        public void run() {
            try {
                byte[] input = new byte[1024];
                // Read request from the client socket
                socket.getInputStream().read(input);
                // process
                byte[] output = process(input);
                // Send response to the client
                socket.getOutputStream().write(output);
            } catch (IOException ex) {
                // ignore
            }
        }

        private byte[] process(byte[] cmd) {
            System.out.println("接收到客户端的数据：" + new String(cmd, 0));

            String outputStr = "Hello Client";
            return outputStr.getBytes();
        }
    }
}