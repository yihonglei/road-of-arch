package com.jpeony.rocketmq.boot;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "your-topic", consumerGroup = "your-consumer_group")
public class Consumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        // 处理接收到的消息
        System.out.println("Received message: " + message);
    }
}