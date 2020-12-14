package com.jpeony.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * -- @SpringBootApplication 启动一个Spring Boot应用程序
 * -- @EnableEurekaServer 注解启动一个服务注册中心提供给其他应用进行会话
 *
 * @author yihonglei
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}