package com.jpeony.rabbitmq.routing;

import com.jpeony.rabbitmq.utils.CommonConsant;
import com.jpeony.rabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Rounting(路由模式)
 *
 * @author yihonglei
 * @date 2018/12/20 22:51
 */
public class RoutingSender {

    /**
     * 路由队列的key
     *
     * @author yihonglei
     * @date 2018/12/21 18:55
     */
    public static void send(String routingKey) throws IOException, TimeoutException {
        // 创建连接
        Connection connection = ConnectionUtil.getConnection();

        // 创建通道
        Channel channel = connection.createChannel();

        // 声明交换机
        channel.exchangeDeclare(CommonConsant.EXCHANGE_NAME_DIRECT, "direct");

        // 消息发送到交换机
        String message = "hello, direct!";
        System.out.println("发送的消息：" + message);
        channel.basicPublish(CommonConsant.EXCHANGE_NAME_DIRECT, routingKey, null, message.getBytes());

        // 资源关闭
        channel.close();
        connection.close();
    }

}
