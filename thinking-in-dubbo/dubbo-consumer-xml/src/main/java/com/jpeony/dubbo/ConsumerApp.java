package com.jpeony.dubbo;


import com.jpeony.dubbo.service.ProviderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * xml 的方式调用
 *
 * @author yihonglei
 */
public class ConsumerApp {
    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        String str = providerService.sayHello("hello");
        System.out.println(str);
        System.in.read();
    }
}
