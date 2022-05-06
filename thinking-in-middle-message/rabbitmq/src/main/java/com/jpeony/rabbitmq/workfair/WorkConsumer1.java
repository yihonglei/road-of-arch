package com.jpeony.rabbitmq.workfair;

import com.jpeony.rabbitmq.utils.CommonConsant;
import com.jpeony.rabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 基于工作队列--消费者
 * @author yihonglei
 * @date 2018/12/18 11:33
 */
public class WorkConsumer1 {

    /**
     * 消费者1
     * @author yihonglei
     * @date 2018/12/18 14:39
     */
    public static void consumer() throws IOException, TimeoutException, InterruptedException {
        // 创建连接
        Connection connection = ConnectionUtil.getConnection();

        // 创建通道
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(CommonConsant.WORK_QUEUE_NAME, false, false, false, null);

        // 一次只处理一个
        channel.basicQos(1);

        // 定义一个消费者监听消息
        Consumer consumer = new DefaultConsumer(channel){
            // 一旦有消息，触发该方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println("消费者1：" + message);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("消费者1：" + "Done");
                    // 业务处理完成，手动ack
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        boolean autoAck = false; // 手动应答
        channel.basicConsume(CommonConsant.WORK_QUEUE_NAME, autoAck, consumer);

        // 让程序处于运行状态，让消费者监听消息
        Thread.sleep(1000 * 60);
    }

}
