package com.jpeony.rabbitmq;

import com.jpeony.rabbitmq.work.WorkSender;
import com.jpeony.rabbitmq.work.WorkConsumer1;
import com.jpeony.rabbitmq.work.WorkConsumer2;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 轮训分发：一个生产者，两个消费者
 *     |-->C1
 * p-->|
 *     |-->C2
 *
 * 消费者1和消费者2处理的消息是一样的。
 * 消费者1：偶数
 * 消费者2：奇数
 * 这种方式叫做轮询分发（round-robin），结果就是不管谁忙活着谁清闲着，都不会多给一个消息，
 * 任务消息按照你一个，我一个的方式消费，两个消费者公平的拿到相同数量的消息，只是时间先后而已。
 *
 * @author yihonglei
 * @date 2018/12/18 16:20
 */
public class WorkTest {

    @Test
    public void sender() throws InterruptedException, TimeoutException, IOException {
        WorkSender.send();
    }

    @Test
    public void consumer1() throws IOException, TimeoutException, InterruptedException {
        WorkConsumer1.consumer();
    }

    @Test
    public void consumer2() throws IOException, TimeoutException, InterruptedException {
        WorkConsumer2.consumer();
    }

}
