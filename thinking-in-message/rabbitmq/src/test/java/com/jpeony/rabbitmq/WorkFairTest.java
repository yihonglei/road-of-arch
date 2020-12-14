package com.jpeony.rabbitmq;

import com.jpeony.rabbitmq.workfair.WorkConsumer1;
import com.jpeony.rabbitmq.workfair.WorkConsumer2;
import com.jpeony.rabbitmq.workfair.WorkSender;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 公平分发：一个生产者，两个消费者
 *     |-->C1
 * p-->|
 *     |-->C2
 *
 * 手动应答
 *
 * @author yihonglei
 * @date 2018/12/18 16:20
 */
public class WorkFairTest {

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
