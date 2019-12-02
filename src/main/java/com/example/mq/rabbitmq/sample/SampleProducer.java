package com.example.mq.rabbitmq.sample;

import com.example.mq.rabbitmq.RabbitMqConstant;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author: lingjun.jlj
 * @date: 2019/8/29 15:00
 * @description:
 */
public class SampleProducer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(RabbitMqConstant.USERNAME);
        factory.setPassword(RabbitMqConstant.PASSWORD);
        factory.setVirtualHost(RabbitMqConstant.VIRTUAL_HOST);
        factory.setHost(RabbitMqConstant.HOST);
        factory.setPort(RabbitMqConstant.PORT);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //durable表示是否持久化
        channel.exchangeDeclare("exchange-test", "direct", true);
        //durable 持久化；exclusive 设置是否排他；autoDelete 是否自动删除，只有当一个消费者连接上后，断开，才会删除队列；arguments 队列参数
        channel.queueDeclare("queue-test", true, false, false, null);
        channel.queueBind("queue-test", "exchange-test", "");
        byte[] message = "Hello World!!!".getBytes();
        channel.basicPublish("exchange-test", "queue-test", null, message);

    }
}
