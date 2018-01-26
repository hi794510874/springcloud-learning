package com.owen;

import com.owen.rabbitmqUtil.RmqConfig;
import com.owen.rabbitmqUtil.RmqHelper;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws IOException, TimeoutException {
        RmqHelper.initAmq();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RmqConfig.getHost());
        factory.setPort(Integer.parseInt(RmqConfig.getPort()));
        factory.setPassword(RmqConfig.getPassWord());
        factory.setUsername(RmqConfig.getUserName());
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        channel.queueBind(RmqHelper.BussinessQueue, RmqHelper.BussinessExchange, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(RmqHelper.BussinessQueue, true, consumer);
    }

}

