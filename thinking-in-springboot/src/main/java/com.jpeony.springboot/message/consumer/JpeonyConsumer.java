package com.jpeony.springboot.message.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


/**
 * 消费者
 *
 * @author yihonglei
 */
@Component
public class JpeonyConsumer {

    @RabbitListener(queues = "jpeonyDirectQueue")
    public void consumerMsg(Message message) {

        System.out.println("消费消息:" + message.getPayload().toString());
    }

    @RabbitListener(queues = "jpeonyFanoutQueue1")
    public void consumerFanoutMsg(Message message) {

        System.out.println("消费消息:" + message.getPayload());
    }

    @RabbitListener(queues = "jpeonyFanoutQueue2")
    public void consumerFanoutMsg2(Message message) {

        System.out.println("消费消息:" + message.getPayload());
    }

    @RabbitListener(queues = "jpeonyTopicQueue")
    public void consumerTopicMsg(Message message) {

        System.out.println("消费消息:" + message.getPayload());
    }

    @RabbitListener(queues = "jpeonyFanoutQueue2")
    public void consumerTopicMsg2(Message message) {

        System.out.println("消费消息:" + message.getPayload());
    }

}
