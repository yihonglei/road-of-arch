package com.jpeony.rabbitmq.simple;

import com.jpeony.rabbitmq.utils.CommonConsant;
import com.jpeony.rabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 简单队列--生产者
 *
 * @author yihonglei
 * @date 2018/12/18 11:11
 */
public class SimpleSender {

    /**
     * 消息生产者
     *
     * @author yihonglei
     * @date 2018/12/13 18:05
     */
    public static void send() throws IOException, TimeoutException {
        // 获取连接
        Connection connection = ConnectionUtil.getConnection();

        // 创建消息通道
        Channel channel = connection.createChannel();

        // 生成一个消息队列
        channel.queueDeclare(CommonConsant.SIMPLE_QUEUE_NAME, true, false, false, null);

        // 消息发送
        String message = "Hello World";
        // 发布消息，第一个参数表示路由（Exchange名称），未""则表示使用默认消息路由
        channel.basicPublish("", CommonConsant.SIMPLE_QUEUE_NAME, null, message.getBytes());
        System.out.println("SimpleSender-：" + message);

        // 关闭消息通道和连接
        channel.close();
        connection.close();
    }

}
