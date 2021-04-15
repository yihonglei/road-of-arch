package com.jpeony.ipc.udp;

import com.jpeony.ipc.udp.server.ChineseProverbServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(-1)
public class ServerBrokerUDPApplicationRunner implements ApplicationRunner {
    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ChineseProverbServer chineseProverbServer;

    @Override
    public void run(ApplicationArguments args) {
        this.logger.info("ServerBrokerUDPApplicationRunner........");
        try {
            this.chineseProverbServer.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
