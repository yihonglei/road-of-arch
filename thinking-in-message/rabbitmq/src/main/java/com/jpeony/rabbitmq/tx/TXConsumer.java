package com.jpeony.rabbitmq.tx;

import com.jpeony.rabbitmq.utils.CommonConsant;
import com.jpeony.rabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 事务测试消费者
 * @author yihonglei
 * @date 2018/12/24 14:09
 */
public class TXConsumer {

    public static void consume() throws IOException, TimeoutException, InterruptedException {

        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(CommonConsant.TX_QUEUE_NAME, false,false,false, null);

        // 消息消费
        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("TXConsumer--message：" + message);

                try {
                    // 模拟业务处理
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("TXConsumer：Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }

        };
        boolean autoAck = true; // 自动确认
        channel.basicConsume(CommonConsant.TX_QUEUE_NAME, autoAck, consumer);

        // 让程序处于运行状态，让消费者监听消息
        Thread.sleep(1000 * 60);
    }

}
