package com.jpeony.annotation.consumer;

import java.util.Date;

import com.jpeony.annotation.api.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Task implements CommandLineRunner {
    @DubboReference
    private HelloService helloService;

    @Override
    public void run(String... args) throws Exception {
        String result = helloService.sayHello("world");
        System.out.println("Receive result ======> " + result);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(new Date() + " Receive result ======> " + helloService.sayHello("world"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
