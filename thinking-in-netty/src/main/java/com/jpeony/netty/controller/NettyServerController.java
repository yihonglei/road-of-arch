package com.jpeony.netty.controller;

import com.jpeony.netty.mq.common.ChannelCache;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.util.CharsetUtil;
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
    @RequestMapping(value = "/serverMsg")
    public String serverMsg() {
        Channel channel = ChannelCache.get("101");

        String responseData = "server send msg to client, Hello Client!";
        channel.writeAndFlush(Unpooled.copiedBuffer(responseData, CharsetUtil.UTF_8));
        return "server send msg to client";
    }
}
