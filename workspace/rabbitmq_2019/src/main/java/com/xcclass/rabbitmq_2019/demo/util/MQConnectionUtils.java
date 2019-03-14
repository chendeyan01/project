package com.xcclass.rabbitmq_2019.demo.util;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MQConnectionUtils {
    public static Connection newConnection() throws Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("chendeyan");
        connectionFactory.setPassword("abc123456");
        connectionFactory.setVirtualHost("/test");
        return connectionFactory.newConnection();

    }

}
