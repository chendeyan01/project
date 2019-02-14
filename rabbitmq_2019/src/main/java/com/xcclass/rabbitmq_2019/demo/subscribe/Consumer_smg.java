package com.xcclass.rabbitmq_2019.demo.subscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xcclass.rabbitmq_2019.demo.util.MQConnectionUtils;

public class Consumer_smg {
    private static final String QUEUE_NAME = "consumerFanout_smg";
    private static final String EXCHANGE_NAME = "fanout_exchange";
    public static void main(String[] args) throws Exception {
        Connection connection = MQConnectionUtils.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");


    }
}
