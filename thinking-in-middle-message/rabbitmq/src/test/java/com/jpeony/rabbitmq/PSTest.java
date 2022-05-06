package com.jpeony.rabbitmq;

import com.jpeony.rabbitmq.ps.PSConsumer1;
import com.jpeony.rabbitmq.ps.PSConsumer2;
import com.jpeony.rabbitmq.ps.PSSender;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 发布/订阅模式
 *
 * @author yihonglei
 * @date 2018/12/19 20:25
 */
public class PSTest {

    /**
     * 消息发送交换机测试
     *
     * @author yihonglei
     * @date 2018/12/19 20:25
     */
    @Test
    public void send() throws IOException, TimeoutException {
        PSSender.send();
    }

    /**
     * 邮箱消费者
     *
     * @author yihonglei
     * @date 2018/12/20 17:21
     */
    @Test
    public void consumerEmail() throws InterruptedException, TimeoutException, IOException {
        PSConsumer1.consumeEmail();
    }

    /**
     * 短信消费者
     *
     * @author yihonglei
     * @date 2018/12/20 17:22
     */
    @Test
    public void consumeSms() throws InterruptedException, TimeoutException, IOException {
        PSConsumer2.consumeSMS();
    }

}
