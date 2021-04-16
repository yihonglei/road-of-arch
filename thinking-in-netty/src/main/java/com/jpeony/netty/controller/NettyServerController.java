package com.jpeony.netty.controller;

import com.jpeony.netty.mq.common.ChannelCache;
import com.jpeony.netty.mq.common.Command;
import com.jpeony.netty.mq.common.Message;
import io.netty.channel.Channel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yihonglei
 */
@RestController
@RequestMapping(value = "/netty/server")
public class NettyServerController {
    @GetMapping
    @RequestMapping(value = "/sendMsg")
    public String sendMsg() {
        String clientId = "101";
        Channel channel = ChannelCache.get("101");

        Message uploadDataMsg = new Message();
        uploadDataMsg.setClientId(clientId);
        uploadDataMsg.setCmd(Command.UPLOAD_DATA);
        uploadDataMsg.setData("服务端往客户端上传数据");

        channel.writeAndFlush(uploadDataMsg);
        return "server send msg to client success!";
    }
}
