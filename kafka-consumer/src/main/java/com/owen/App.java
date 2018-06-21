package com.owen;

import com.owen.model.CheckChangeMsg;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 为收集日志而生，高吞吐 性能彪悍
 * <p>
 * kafka的java客户端poll阻塞问题解决方法
 * https://www.fish2bird.com/?p=658
 * <p>
 * <p>
 * 在线程池的情况下 精细提交offset 异常 kafkaconsumer不允许多线程调用
 * https://blog.csdn.net/lmmzsn/article/details/78716824
 * <p>
 * consumer配置参数
 * http://orchome.com/535
 */
public class App {
    public static void main(String[] args) {
        int threadPoolSize = 10;
        int blockQueueSize = 30;
        Properties propss = new Properties();
        propss.put("bootstrap.servers", "192.168.119.128:9092");
        propss.put("group.id", "test");
        propss.put("enable.auto.commit", "true");//自动提交offset  auto.commit.interval.ms 默认5000ms
        propss.put("auto.commit.interval.ms", "1000");
        propss.put("session.timeout.ms", "30000");
        propss.put("max.poll.records", threadPoolSize);//每次consumer 拿多少条
        propss.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        propss.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        //propss.put("max.partition.fetch.bytes", "1048576");//从分区获取消息的最大大小 字节 默认 1048576


        final KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(propss);
        Map<String, List<PartitionInfo>> listMaps = kafkaConsumer.listTopics();
        kafkaConsumer.subscribe(Arrays.asList("test"));

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, threadPoolSize, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(blockQueueSize));

        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);//要注意两次poll之间的处理时间 默认是300000ms 超过会触发再平衡
            int activeCount = executor.getActiveCount();
            int threadPoolSizes = executor.getPoolSize();
            int queueSize = executor.getQueue().size();
            // System.out.println("excuting task:" + activeCount + "   poolSize:" + threadPoolSizes + "   queueSize:" + queueSize);

            if (blockQueueSize < queueSize + threadPoolSize) {
                while (blockQueueSize < queueSize + threadPoolSize) {
                    queueSize = executor.getQueue().size();//当前队列的内容+线程池的线程 大于 定义的缓存队列数 则等待后面处理完
                    System.out.println("    queueSize + threadPoolSize:" + (queueSize + threadPoolSize));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            for (final ConsumerRecord<String, String> record : records) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.printf("offset = %d, value = %s", record.offset(), record.value());
                            System.out.println();

                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }
}
