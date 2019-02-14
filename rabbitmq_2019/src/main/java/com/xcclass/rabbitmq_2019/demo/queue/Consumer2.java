package com.xcclass.rabbitmq_2019.demo.queue;

import com.rabbitmq.client.*;
import com.xcclass.rabbitmq_2019.demo.util.MQConnectionUtils;

import java.io.IOException;

public class Consumer2 {
    private static final String QUEUE_NAME = "test_queue";
    public static void main(String[] args) {
        System.out.println("===========消费者启动============");
        try {
            Connection connection = MQConnectionUtils.newConnection();
            //获取通道
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            channel.basicQos(1);
            DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "utf-8");
                    System.out.println(message);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //手动回执消息
                    channel.basicAck(envelope.getDeliveryTag(), true);
                }
            };
            //监听队列
            channel.basicConsume(QUEUE_NAME,false,defaultConsumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
