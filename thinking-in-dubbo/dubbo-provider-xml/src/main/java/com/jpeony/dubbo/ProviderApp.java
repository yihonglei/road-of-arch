package com.jpeony.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * xml 方式启动
 *
 * @author yihonglei
 */
public class ProviderApp {
    public static void main(String[] args) throws IOException {
        // 加载 xml 配置文件启动
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/provider.xml");
        context.start();
        // 按任意键退出
        System.in.read();
    }
}
