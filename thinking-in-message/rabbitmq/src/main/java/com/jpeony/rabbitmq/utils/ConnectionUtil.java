package com.jpeony.rabbitmq.utils;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * RabbitMQ连接工具
 *
 * @author yihonglei
 * @date 2018/12/17 10:25
 */
public class ConnectionUtil {

    /**
     * 创建Connection
     *
     * @author yihonglei
     * @date 2018/12/17 10:27
     */
    public static Connection getConnection() throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/vhost_yihonglei");
        factory.setUsername("guest");
        factory.setPassword("guest");

        // 创建连接
        Connection connection = factory.newConnection();

        return connection;
    }

}
