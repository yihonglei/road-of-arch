package com.jpeony.rabbitmq;

import com.jpeony.rabbitmq.simple.SimpleConsumer;
import com.jpeony.rabbitmq.simple.SimpleSender;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * RabbitMQ生产-->简单队列-->消费测试
 *
 * @author yihonglei
 * @date 2018/12/13 17:07
 */
public class SimpleTest {

    /**
     * 消息生产者
     *
     * @author yihonglei
     * @date 2018/12/13 18:05
     */
    @Test
    public void send() throws IOException, TimeoutException {
        SimpleSender.send();
    }

    /**
     * 消息消费者
     *
     * @author yihonglei
     * @date 2018/12/13 18:05
     */
    @Test
    public void consumer() throws IOException, TimeoutException, InterruptedException {
        SimpleConsumer.consume();
    }
}
