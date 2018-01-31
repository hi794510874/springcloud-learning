package com.owen.rabbitmqUtil;

import com.rabbitmq.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by huang_b on 2018/1/25.
 */
@Component
public class RmqHelper {
    /*交换机名称*/
    public static final String EntryExchange = "what.Exchange.Entry";
    public static final String LogExchange = "what.Exchange.4Log";
    public static final String BussinessExchange = "what.Exchange.4Bussiness";
    public static final String ManagerExchange = "what.Exchange.Manager";

    /*队列名称*/
    public static final String LogQueue = "what.Queue.4Log";
    public static final String BussinessQueue = "what.Queue.4Bussiness";

    @Autowired
    private RmqConfig rmqConfig;

    public void send(String msg) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rmqConfig.getrmqHost());
        factory.setPort(Integer.parseInt(rmqConfig.getRmqProt()));
//        factory.setVirtualHost("test");
        factory.setUsername(rmqConfig.getRmqUserName());
        factory.setPassword(rmqConfig.getRmqPassword());
        //factory.setVirtualHost("fox");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties().builder().deliveryMode(2).build();
        channel.basicPublish(EntryExchange, BussinessQueue, basicProperties, msg.getBytes());
        channel.close();
        connection.close();

    }

    public void initAmq() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rmqConfig.getrmqHost());
        factory.setPort(Integer.parseInt(rmqConfig.getRmqProt()));
//        factory.setVirtualHost("test");
        factory.setUsername(rmqConfig.getRmqUserName());
        factory.setPassword(rmqConfig.getRmqPassword());
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        /* 声明交换机*/
        channel.exchangeDeclare(EntryExchange, BuiltinExchangeType.FANOUT, true);//交换机名称 交换机类型
        channel.exchangeDeclare(LogExchange, BuiltinExchangeType.TOPIC, true);
        channel.exchangeDeclare(BussinessExchange, BuiltinExchangeType.DIRECT, true);

        channel.exchangeDeclare(ManagerExchange, BuiltinExchangeType.FANOUT, false);

        /*交换机绑定交换机*/
        channel.exchangeBind(LogExchange, EntryExchange, "");
        channel.exchangeBind(BussinessExchange, EntryExchange, "");

        /*声明队列*/
        channel.queueDeclare(LogQueue, true, false, false, null);//队列名  是否持久化
        channel.queueDeclare(BussinessQueue, true, false, false, null);

        /*队列绑定交换机*/
        channel.queueBind(LogQueue, LogExchange, LogQueue);
        channel.queueBind(BussinessQueue, BussinessExchange, BussinessQueue);

        channel.close();
        connection.close();

    }
}
