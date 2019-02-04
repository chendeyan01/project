package com.xcclass.rabbitmq_2019.demo.queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xcclass.rabbitmq_2019.demo.util.MQConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    private static final String QUEUE_NAME = "test_queue";
    public static void main(String[] args) {
        System.out.println("===========生产者启动============");
        Connection connection = null;
        Channel channel = null;
        try {
            connection = MQConnectionUtils.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            for(int i=0;i<50;i++){
                String message="陈德炎我爱你"+i;
                System.out.println(message);
                channel.basicPublish("", QUEUE_NAME, null,message.getBytes());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }

        }


    }
}
