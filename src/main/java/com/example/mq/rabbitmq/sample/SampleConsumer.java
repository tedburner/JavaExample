package com.example.mq.rabbitmq.sample;

import com.example.constant.RabbitMqConstant;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * @author: lingjun.jlj
 * @date: 2019/8/29 15:11
 * @description:
 */
public class SampleConsumer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(RabbitMqConstant.USERNAME);
        factory.setPassword(RabbitMqConstant.PASSWORD);
        factory.setVirtualHost(RabbitMqConstant.VIRTUAL_HOST);
        factory.setHost(RabbitMqConstant.HOST);
        factory.setPort(RabbitMqConstant.PORT);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(64);
        channel.basicConsume("queue-test", false, "myConsumerTag", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String routingKey = envelope.getRoutingKey();
                String contentType = properties.getContentType();
                long deliverTag = envelope.getDeliveryTag();
                channel.basicAck(deliverTag, false);

            }
        });
    }
}
