package com.jpeony.rocketmq.four;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * 消费者
 *
 * @author yihonglei
 */
public class ConsumerTest {
    public static void main(String[] args) throws MQClientException {
        // 初始化 Consumer，并设置 consumer group name
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test-consumer-groupName");
        // 设置 NameServer 地址
        consumer.setNamesrvAddr("10.6.202.110:9876;10.6.202.111:9876");

        consumer.setInstanceName("test_consumer");

        // 订阅一个或多个 topic，并指定 tag 过滤条件，这里指定 * 表示接收所有 tag 的消息【实际业务建议只订阅一个 topic】
        consumer.subscribe("test_topic", "*"); // 指定 tag 过滤 tag_a || tag_b || tag_c

        // 注册回调接口来处理从 Broker 中收到的消息
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            for (MessageExt msg : msgs) {
                String messageExtStr = new String(msg.getBody());
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), messageExtStr);
            }
            // 返回消息消费状态，ConsumeConcurrentlyStatus.CONSUME_SUCCESS 为消费成功
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        // 启动 Consumer
        consumer.start();
        System.out.println("Consumer Started!");
    }
}