package com.owen.rabbitmqUtil;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by huang_b on 2018/1/25.
 */
public class RmqHelper {

    //todo：记录日志的模块后续跟上
    public static void Send() {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        try {
            Channel channel = connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
