package com.owen.consumer;

import com.owen.DealMessageResult;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by huang_b on 2018/2/8.
 */
public class ManagerConsumer extends BaseConsumer {

    @Override
    public DealMessageResult handleMessage(String msg) throws IOException, TimeoutException {
        DealMessageResult dealMessageResult = new DealMessageResult();
        System.out.println(" [x] ManagerConsumer Received '" + msg + "'");
        if (msg.toUpperCase().contains("STOP")) {
            stopConsumer(msg);
        }
        if (msg.toUpperCase().contains("START")) {
            startConsumer(msg);
        }
        return dealMessageResult;
    }

    public void stopConsumer(String msg) throws IOException, TimeoutException {
        String consumerKey=msg.split("-")[1];
        BaseConsumer consumer = listConsumers.get(consumerKey);
        if (consumer != null) {
            consumer.stopConsumer();
            listConsumers.remove(msg);
        }
    }

    public void startConsumer(String msg) throws IOException, TimeoutException {
//        todo:根据传进来的参数 反射创建一个consumer对象 调用 startconsumer方法   并将对象放到 listConsumers中
    }
}
