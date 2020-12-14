package com.jpeony.springboot.service.impl;

import com.jpeony.springboot.service.IHelloService;
import org.springframework.stereotype.Service;

/**
 * @author yihonglei
 */
@Service
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }

}
