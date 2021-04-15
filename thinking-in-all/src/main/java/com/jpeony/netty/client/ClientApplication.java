package com.jpeony.netty.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:/application.properties"})
@ComponentScan(basePackages = {"com.jpeony"})
public class ClientApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ClientApplication.class, args);
    }
}