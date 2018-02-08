package com.owen;

import com.owen.consumer.BussinessConsumer;
import com.owen.rabbitmqUtil.RmqConfig;
import com.owen.rabbitmqUtil.RmqHelper;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 一个交换机  队列 消息 都持久化的 rabbitmq 消费者，手动ack  能保证每个消息都被处理不会丢失且不会被重复处理  重要业务场景 稳定可靠
 * 处理流程  service-provider 发送rmq消息 ， rmq-consumer 每次接收20条消息 并开启线程池来并行处理
 */
public class App {

    public static void main(String[] args) throws TimeoutException, IOException {

        RmqHelper.initAmq();
        BussinessConsumer bussinessConsumer = new BussinessConsumer();
        bussinessConsumer.queueName = RmqHelper.BussinessQueue;
        bussinessConsumer.start();

//-------------------------------------------下面的代码是ok 的------------------------------------------------------------//
    /*    int threadPoolSize = 20;

//        http://blog.csdn.net/qq_25806863/article/details/71126867
        //这种情况是    首先开启 corePoolSize个常驻线程 多的消息来了，开新的线程  当队列达到 capacity的之后 抛出异常 不在工作
        final ThreadPoolExecutor executor = new ThreadPoolExecutor(3, threadPoolSize, 2, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(10));

        RmqHelper.initAmq();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RmqConfig.getHost());
        factory.setPort(Integer.parseInt(RmqConfig.getPort()));
        factory.setPassword(RmqConfig.getPassWord());
        factory.setUsername(RmqConfig.getUserName());
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.basicQos(0, threadPoolSize, false);
        channel.queueBind(RmqHelper.BussinessQueue, RmqHelper.BussinessExchange, "");

        Consumer consumer = new DefaultConsumer(channel) {


            @Override
            public void handleDelivery(String consumerTag, final Envelope envelope,
                                       AMQP.BasicProperties properties, final byte[] body) throws IOException {

                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String message = new String(body, "UTF-8");
                            System.out.println(" [x] Received '" + message + "'");

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
                                channel.basicAck(envelope.getDeliveryTag(), false);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        };

        channel.basicConsume(RmqHelper.BussinessQueue, false, consumer);*/
    }

}

