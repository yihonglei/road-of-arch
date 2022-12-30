package com.jpeony.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.TimeUnit;

/**
 * 生产者
 *
 * @author yihonglei
 */
public class Producer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        // 初始化一个 Producer 并设置 Producer group name
        final DefaultMQProducer producer = new DefaultMQProducer("test-producer-groupName");
        // 设置 NameServer 地址
        producer.setNamesrvAddr("10.6.202.110:9876;10.6.202.111:9876");
        producer.setInstanceName("test-producer");

        // 启动 Producer
        producer.start();

        // 发送消息
        for (int i = 0; i < 10; i++) {
            try {
                // 创建一条消息，并指定 topic、tag、body 等信息，tag 可以理解成标签，对消息进行再归类，RocketMQ 可以在消费端对 tag 进行过滤
                String msgBody = "Hello RocketMQ " + i;
                Message rocketMsg = new Message("test_topic" /* Topic */,
                        "tag_a" /* Tag */,
                        msgBody.getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */);
                // 利用 Producer 进行发送，并同步等待发送结果
                SendResult sendResult = producer.send(rocketMsg);
                System.out.println(sendResult);
            } catch (Exception e) {
                e.printStackTrace();
            }
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        /*
         * 应用退出时，要调用 shutdown 来清理资源，关闭网络连接，从 MetaQ 服务器上注销自己
         * 注意：我们建议应用在 JBOSS、Tomcat 等容器的退出钩子里调用 shutdown 方法
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