package com.jpeony.netty.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * @author yihonglei
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8989);

        // 向服务端发送数据
        socket.getOutputStream().write("Hello Server!".getBytes());
        socket.getOutputStream().flush();
        System.out.println("向服务端发送数据结束");

        // 接收服务端响应数据
        byte[] bytes = new byte[1024];
        int read = socket.getInputStream().read(bytes);
        System.out.println("接收服务端响应数据：" + new String(bytes, 0, read));
        socket.close();
    }
}