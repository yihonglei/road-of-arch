package com.jpeony.ipc.tcp;

import com.jpeony.ipc.tcp.server.TCPServerBrokerStart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class ServerBrokerApplicationRunner implements ApplicationRunner {
    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TCPServerBrokerStart tcpServerBrokerStart;

    @Override
    public void run(ApplicationArguments args) {
        this.logger.info("开始ServerBrokerApplicationRunner......");
        this.tcpServerBrokerStart.start();
    }
}
