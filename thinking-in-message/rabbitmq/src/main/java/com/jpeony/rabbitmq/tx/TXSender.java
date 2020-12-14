package com.jpeony.rabbitmq.tx;

import com.jpeony.rabbitmq.utils.CommonConsant;
import com.jpeony.rabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消息确认事务机制测试
 * @author yihonglei
 * @date 2018/12/24 13:37
 */
public class TXSender {

    public static void send() throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(CommonConsant.TX_QUEUE_NAME, false,false,false, null);

        String message = "hello tx message";

        try {
            channel.txSelect();
            channel.basicPublish("", CommonConsant.TX_QUEUE_NAME, null, message.getBytes());
            System.out.println("TXSender:" + message);
            channel.txCommit();
        } catch (Exception e) {
            System.out.println("tx rollback!");
            channel.txRollback();
        }

        channel.close();
        connection.close();
    }

}
