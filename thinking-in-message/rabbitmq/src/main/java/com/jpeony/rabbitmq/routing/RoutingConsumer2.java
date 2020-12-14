package com.jpeony.rabbitmq.routing;

import com.jpeony.rabbitmq.utils.CommonConsant;
import com.jpeony.rabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 【路由模式】模拟info、error、warning级别的消费，即路由的key列表为info、error、warning
 *
 * @author yihonglei
 * @date 2018/12/20 22:52
 */
public class RoutingConsumer2 {

    /**
     * 监听Rounting key为info、error、warning的消费者
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
        channel.queueDeclare(CommonConsant.DIRECT_QUEUE2_NAME, false, false, false, null);

        channel.basicQos(1);

        // 队列绑定到交换机，如果有多个Rounting key，需要都绑定
        channel.queueBind(CommonConsant.DIRECT_QUEUE2_NAME, CommonConsant.EXCHANGE_NAME_DIRECT, CommonConsant.ROUNTING_KEY_ERROR);
        channel.queueBind(CommonConsant.DIRECT_QUEUE2_NAME, CommonConsant.EXCHANGE_NAME_DIRECT, CommonConsant.ROUNTING_KEY_INFO);
        channel.queueBind(CommonConsant.DIRECT_QUEUE2_NAME, CommonConsant.EXCHANGE_NAME_DIRECT, CommonConsant.ROUNTING_KEY_WARNING);

        // 消息消费
        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("RoutingConsumer2--message：" + message);

                try {
                    // 模拟业务处理
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("RoutingConsumer2：Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }

        };
        boolean autoAck = false;
        channel.basicConsume(CommonConsant.DIRECT_QUEUE2_NAME, autoAck, consumer);

        // 让程序处于运行状态，让消费者监听消息
        Thread.sleep(1000 * 60);
    }

}
