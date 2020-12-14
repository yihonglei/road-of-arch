package com.jpeony.rabbitmq.topic;

import com.jpeony.rabbitmq.utils.CommonConsant;
import com.jpeony.rabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Topic模式生产者
 *
 * @author yihonglei
 * @date 2018/12/22 21:51
 */
public class TopicSender {

    public static void send() throws IOException, TimeoutException {
        // 创建连接
        Connection connection = ConnectionUtil.getConnection();

        // 创建通道
        Channel channel = connection.createChannel();

        // 声明交换机
        channel.exchangeDeclare(CommonConsant.EXCHANGE_NAME_TOPIC, "topic");

        // 消息发送
        String message = "商品....";
        channel.basicPublish(CommonConsant.EXCHANGE_NAME_TOPIC, CommonConsant.TOPIC_KEY_GOODS_ADD, null, message.getBytes());
        System.out.println("Topic-Send：" + message);

        channel.close();
        connection.close();
    }

}
