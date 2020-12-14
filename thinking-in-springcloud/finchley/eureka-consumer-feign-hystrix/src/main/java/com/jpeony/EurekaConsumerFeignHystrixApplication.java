package com.jpeony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * -- @SpringBootApplication 启动一个Spring Boot应用程序
 * -- @EnableDiscoveryClient 服务发现与注册，当应用启动时，将应用注册到配置的注册中心
 *
 * @author yihonglei
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
@EnableFeignClients(basePackages = "com.jpeony")
public class EurekaConsumerFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerFeignHystrixApplication.class, args);
    }
}