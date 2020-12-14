package com.jpeony.rabbitmq.ps;

import com.jpeony.rabbitmq.utils.CommonConsant;
import com.jpeony.rabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消息发送到交换机
 *
 * @author yihonglei
 * @date 2018/12/19 20:17
 */
public class PSSender {

    public static void send() throws IOException, TimeoutException {
        // 创建连接
        Connection connection = ConnectionUtil.getConnection();

        // 创建通道
        Channel channel = connection.createChannel();

        // 声明交换机
        channel.exchangeDeclare(CommonConsant.EXCHANGE_NAME_FANOUT, "fanout"); // 分发

        // 发送消息(将消息发送到交换机)
        String message = "hello, ps!";
        channel.basicPublish(CommonConsant.EXCHANGE_NAME_FANOUT, "", null, message.getBytes());
        System.out.println("PS-Send：" + message);

        // 关闭连接
        channel.close();
        connection.close();
    }

}
