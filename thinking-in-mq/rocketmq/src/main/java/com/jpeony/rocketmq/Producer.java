package com.jpeony.rocketmq;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 生产者
 *
 * @author yihonglei
 */
public class Producer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        final DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setInstanceName("Producer");

        /*
         * Rocket默认开启了VIP通道，VIP通道端口为10911-2=10909。
         * 而broker默认端口为10911，找不到10909服务，则报connect to <：10909> failed。
         * 设置为false，关闭VIP通道。
         */
        producer.setVipChannelEnabled(false);

        // 启动生产者
        producer.start();

        // 发送消息
        for (int i = 0; i < 10; i++) {
            try {
                String msg = "Hello RocketMQA";
                Message rocketMsg =
                        new Message("TopicTest", "TagA", "OrderID00", msg.getBytes(StandardCharsets.UTF_8));

                SendResult sendResult = producer.send(rocketMsg);
                System.out.println(sendResult);
            } catch (Exception e) {
                e.printStackTrace();
            }
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        /*
         * 应用退出时，要调用shutdown来清理资源，关闭网络连接，从MetaQ服务器上注销自己 
         * 注意：我们建议应用在JBOSS、Tomcat等容器的退出钩子里调用shutdown方法 
         */
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                producer.shutdown();
            }
        }));

        System.exit(0);
    }
}