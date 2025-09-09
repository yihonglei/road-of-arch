package com.jpeony.springboot.service.impl;

import com.jpeony.springboot.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author yihonglei
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }

}
