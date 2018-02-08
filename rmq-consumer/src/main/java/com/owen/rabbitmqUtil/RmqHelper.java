package com.owen.rabbitmqUtil;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by huang_b on 2018/1/25.
 */
public class RmqHelper {
    /*交换机名称*/
    public static final String EntryExchange = "what.Exchange.Entry";
    public static final String LogExchange = "what.Exchange.4Log";
    public static final String BussinessExchange = "what.Exchange.4Bussiness";
    public static final String ManagerExchange = "what.Exchange.Manager";

    /*队列名称*/
    public static final String LogQueue = "what.Queue.4Log";
    public static final String BussinessQueue = "what.Queue.4Bussiness";
    public static final String ManagerQueue = "what.Queue.4Manager";

    RmqConfig rmqConfig = new RmqConfig();


    public static void initAmq() throws IOException, TimeoutException {
        RmqConfig.loadProperties();
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RmqConfig.getHost());
        factory.setPort(Integer.parseInt(RmqConfig.getPort()));
//        factory.setVirtualHost("test");
        factory.setUsername(RmqConfig.getUserName());
        factory.setPassword(RmqConfig.getPassWord());
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
        channel.queueDeclare(ManagerQueue, false, false, true, null);

        /*队列绑定交换机*/
        channel.queueBind(LogQueue, LogExchange, LogQueue);
        channel.queueBind(BussinessQueue, BussinessExchange, BussinessQueue);
        channel.queueBind(ManagerQueue, ManagerExchange, "");

        channel.close();
        connection.close();

    }
}
