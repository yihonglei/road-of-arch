package com.jpeony.netty;

import com.jpeony.netty.mq.client.NettyClientManager;
import com.jpeony.netty.mq.common.NettyServerManager;
import com.jpeony.netty.mq.server.NettyServer;
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
        System.out.println("Netty server start ......");
        NettyServerManager serverManager = NettyServerManager.getInstance();
        serverManager.start();
        System.out.println("Netty server start success!");

        // netty client start
        System.out.println("Netty client start ......");
        NettyClientManager clientManager = NettyClientManager.getInstance();
        clientManager.start();
        System.out.println("Netty client success!");
    }
}
