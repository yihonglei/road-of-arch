package com.jpeony.netty.controller;

import com.jpeony.netty.mq.client.NettyClientManager;
import com.jpeony.netty.mq.common.Command;
import com.jpeony.netty.mq.common.Message;
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
            Message pushDataMsg = new Message();
            pushDataMsg.setClientId(clientId);
            pushDataMsg.setCmd(Command.PUSH_DATA);
            pushDataMsg.setData("hello server, I am clientId " + clientId);

            NettyClientManager producer = NettyClientManager.getInstance();
            producer.send(pushDataMsg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "netty client send msg to server success!";
    }
}
