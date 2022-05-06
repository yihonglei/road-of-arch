package com.jpeony.rabbitmq.topic;

import com.jpeony.rabbitmq.utils.CommonConsant;
import com.jpeony.rabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 【topic模式】固定RoutingKey(goods.add)，消费添加商品消息
 *
 * @author yihonglei
 * @date 2018/12/20 22:52
 */
public class TopicConsumer1 {

    /**
     *
     * @author yihonglei
     * @date 2018/12/21 18:55
     */
    public static void consume() throws IOException, TimeoutException, InterruptedException {
        // 创建连接
        Connection connection = ConnectionUtil.getConnection();

        // 创建通道
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(CommonConsant.TOPIC_QUEUE1_NAME, false, false, false, null);

        channel.basicQos(1);

        // 队列绑定到交换机，goods.add，固定匹配
        channel.queueBind(CommonConsant.TOPIC_QUEUE1_NAME, CommonConsant.EXCHANGE_NAME_TOPIC, CommonConsant.TOPIC_KEY_GOODS_ADD);

        // 消息消费
        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("TopicConsumer1--message：" + message);

                try {
                    // 模拟业务处理
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("TopicConsumer1：Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }

        };
        boolean autoAck = false;
        channel.basicConsume(CommonConsant.TOPIC_QUEUE1_NAME, autoAck, consumer);

        // 让程序处于运行状态，让消费者监听消息
        Thread.sleep(1000 * 60);
    }

}
