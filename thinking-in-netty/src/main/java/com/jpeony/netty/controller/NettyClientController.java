package com.jpeony.netty.controller;

import com.jpeony.netty.auto.client.NettyClientManager;
import com.jpeony.netty.auto.common.MessageData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yihonglei
 */
@RestController
@RequestMapping(value = "/netty/client")
public class NettyClientController {
    @GetMapping(value = "/sendMsg")
    public String nettyClient(String clientId) {
        try {
            MessageData messageData = new MessageData();
            messageData.setClientId(clientId);
            messageData.setMessage("hello server, I am " + clientId);

            NettyClientManager producer = NettyClientManager.getInstance();
            producer.send(messageData);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "netty client send msg success!";
    }
}
