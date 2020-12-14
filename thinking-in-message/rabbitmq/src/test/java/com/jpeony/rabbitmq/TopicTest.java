package com.jpeony.rabbitmq;

import com.jpeony.rabbitmq.topic.TopicConsumer1;
import com.jpeony.rabbitmq.topic.TopicConsumer2;
import com.jpeony.rabbitmq.topic.TopicSender;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Topic（主题模式）测试
 *
 * @author yihonglei
 * @date 2018/12/22 22:49
 */
public class TopicTest {

    @Test
    public void send() throws IOException, TimeoutException {
        TopicSender.send();
    }

    @Test
    public void consumer1() throws InterruptedException, TimeoutException, IOException {
        TopicConsumer1.consume();
    }

    @Test
    public void consumer2() throws InterruptedException, TimeoutException, IOException {
        TopicConsumer2.consume();
    }

}
