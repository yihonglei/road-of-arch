package com.jpeony.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * -- @SpringBootApplication 启动一个Spring Boot应用程序
 * -- @EnableDiscoveryClient 服务发现与注册，当应用启动时，将应用注册到配置的注册中心
 *
 * @author yihonglei
 */
@SpringBootApplication
@EnableHystrixDashboard
public class EurekaHystrixDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaHystrixDashboardApplication.class, args);
    }
}