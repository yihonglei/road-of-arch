package com.jpeony.netty.client;

import com.jpeony.netty.client.initializer.ClientStart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ClientApplicationRunner implements ApplicationRunner {
    public Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(ApplicationArguments args) {
        this.logger.info("开始ClientApplicationRunner........");
        (new ClientStart()).start();
    }
}