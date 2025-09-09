package com.jpeony.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关工程，@EnableZuulProxy开启网关支持
 *
 * @author yihonglei
 */
@SpringBootApplication
@EnableZuulProxy
public class EurekaGatewayZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaGatewayZuulApplication.class, args);
    }
}