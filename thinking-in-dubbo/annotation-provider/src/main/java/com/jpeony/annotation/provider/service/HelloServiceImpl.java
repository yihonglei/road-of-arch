package com.jpeony.annotation.provider.service;

import com.jpeony.annotation.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String userName) {
        return "Hello, " + userName;
    }
}
