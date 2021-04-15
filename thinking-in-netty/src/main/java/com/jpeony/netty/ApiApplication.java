package com.jpeony.netty;

import com.jpeony.netty.auto.client.NettyClient;
import com.jpeony.netty.auto.client.NettyClientManager;
import com.jpeony.netty.auto.server.NettyServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yihonglei
 */
@SpringBootApplication(scanBasePackages = "com.jpeony.netty.*")
public class ApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        // netty server start
        System.out.println("netty server start ......");
        NettyServer server = new NettyServer("127.0.0.1", 8888);
        server.start();
        System.out.println("netty server start success!");


        // netty client start
        System.out.println("netty client start ......");
        NettyClientManager clientManager = NettyClientManager.getInstance();
        clientManager.start();
        System.out.println("netty client success!");
    }
}
