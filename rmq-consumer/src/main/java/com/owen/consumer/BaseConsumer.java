package com.owen.consumer;

import com.owen.DealMessageResult;
import com.owen.rabbitmqUtil.RmqConfig;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Dictionary;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by huang_b on 2018/2/6.
 */
public abstract class BaseConsumer {
    public abstract DealMessageResult handleMessage(String msg) throws IOException, TimeoutException;

    public String queueName;
    Connection connection = null;
    Channel channel = null;
    ThreadPoolExecutor executor;
    public Dictionary<String, BaseConsumer> listConsumers;

    public void startConsumer() throws IOException, TimeoutException {
        int threadPoolSize = 20;

//        http://blog.csdn.net/qq_25806863/article/details/71126867
        //这种情况是    首先开启 corePoolSize个常驻线程 多的消息来了，开新的线程  当队列达到 capacity的之后 抛出异常 不在工作
        executor = new ThreadPoolExecutor(3, threadPoolSize, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(10));

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RmqConfig.getHost());
        factory.setPort(Integer.parseInt(RmqConfig.getPort()));
        factory.setPassword(RmqConfig.getPassWord());
        factory.setUsername(RmqConfig.getUserName());
        connection = factory.newConnection();
        channel = connection.createChannel();

        channel.basicQos(0, threadPoolSize, false);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, final Envelope envelope,
                                       AMQP.BasicProperties properties, final byte[] body) throws IOException {

                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String message = new String(body, "UTF-8");
                            DealMessageResult dealMessageResult = handleMessage(message);
                            System.out.println("核心线程数" + executor.getCorePoolSize());
                            System.out.println("线程池数" + executor.getPoolSize());
                            System.out.println("队列任务数" + executor.getQueue().size());
                            System.out.println(" [x] Received '休息 3s'    " + Thread.currentThread().getName() + " run");
                            Thread.sleep(3000);
//                    throw new Exception();
                        } catch (Exception e) {
                            //处理失败的拒绝， 并且不重新入队列
//                          channel.basicReject(envelope.getDeliveryTag(), false);
                        } finally {
                            //处理完后 ack  不管前面处理的时候 是否异常
                            try {
                                System.out.println("deliveryTag:" + envelope.getDeliveryTag());
                                channel.basicAck(envelope.getDeliveryTag(), false);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }

            @Override
            public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {

            }


        };
        channel.basicConsume(queueName, false, consumer);
    }

    public void stopConsumer() throws IOException, TimeoutException {
        while (true) {
            //等待线程池中的队列处理完 已接收的消息
            int queueSize = executor.getQueue().size();
            if (queueSize == 0) {
                break;
            }
        }
        channel.close();
        connection.close();
    }

}
