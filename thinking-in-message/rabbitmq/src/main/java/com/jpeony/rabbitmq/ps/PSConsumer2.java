package com.jpeony.rabbitmq.ps;

import com.jpeony.rabbitmq.utils.CommonConsant;
import com.jpeony.rabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者2（短信发送消费者）
 *
 * @author yihonglei
 * @date 2018/12/20 10:33
 */
public class PSConsumer2 {

    public static void consumeSMS() throws IOException, TimeoutException, InterruptedException {
        // 创建连接
        Connection connection = ConnectionUtil.getConnection();

        // 创建通道
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(CommonConsant.EXCHANGE_NAME_FANOUT_SMS, false, false, false, null);

        // 将队列绑定到交换机
        channel.queueBind(CommonConsant.EXCHANGE_NAME_FANOUT_SMS, CommonConsant.EXCHANGE_NAME_FANOUT, "");

        channel.basicQos(1); // 保证一次只分发一个消息，直到处理完，再接受下一个消息

        // 定义一个消费者
        Consumer consumer = new DefaultConsumer(channel) {
            // 消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("PS-SMS-Consumer1：" + msg);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("PS-SMS-Consumer1：Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        boolean autoAck = false;
        channel.basicConsume(CommonConsant.EXCHANGE_NAME_FANOUT_SMS, autoAck, consumer);

        // 让程序处于运行状态，让消费者监听消息
        Thread.sleep(1000 * 60);
    }

}
