package com.owen;

import com.owen.rabbitmqUtil.RmqConfig;
import com.owen.rabbitmqUtil.RmqHelper;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws IOException, TimeoutException {

        int threadPoolSize = 20;

//        http://blog.csdn.net/qq_25806863/article/details/71126867
        //这种情况是    首先开启 corePoolSize个常驻线程 当队列满了的时候 在去开启 新的线程 当线程池中的数量达到threadPoolSize 抛出异常
        final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, threadPoolSize, 2, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(3));

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

        channel.basicConsume(RmqHelper.BussinessQueue, false, consumer);
    }

}

