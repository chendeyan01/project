package com.xcclass.rabbitmq_2019.demo.subscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xcclass.rabbitmq_2019.demo.util.MQConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static final String EXCHANGE_NAME="exchange_name";
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Connection connection=null;
        Channel channel=null;
        try {
           connection = MQConnectionUtils.newConnection();
           channel = connection.createChannel();
            //声明交换机 参数1 交换机名称  参数2 交换机类型
            channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
            String message="订阅成功";
            channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
