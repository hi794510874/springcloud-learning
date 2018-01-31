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
        final Channel channel = connection.createChannel();

        channel.basicQos(0, 20, false);
        channel.queueBind(RmqHelper.BussinessQueue, RmqHelper.BussinessExchange, "");

        Consumer consumer = new DefaultConsumer(channel) {


            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
//                    throw new Exception();
                } catch (Exception e) {
                    //处理失败的拒绝， 并且不重新入队列
//                    channel.basicReject(envelope.getDeliveryTag(), false);
                } finally {
                    //处理完后 ack  不管前面处理的时候 是否异常
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        channel.basicConsume(RmqHelper.BussinessQueue, false, consumer);
    }

}

