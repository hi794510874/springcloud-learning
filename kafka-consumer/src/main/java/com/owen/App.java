package com.owen;

import com.owen.model.CheckChangeMsg;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.kafka.clients.admin.RecordsToDelete;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
 * 自动提交时如何执行的  下一次 poll 的时候会去提交,设置了auto.commit.interval.ms也是一样  maybeAutoCommitOffsetsAsync
 * https://stackoverflow.com/questions/46546489/how-does-kafka-consumer-auto-commit-work
 * <p>
 * consumer配置参数
 * http://orchome.com/535
 *
 * consumer.close() 会通知broker 自己退出了   自动触发 rebalance
 */
public class App {
    private static Logger logger= LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        int availProcessors = Runtime.getRuntime().availableProcessors();//获取可用的cpu数
        availProcessors=10;
        int threadPoolSize = availProcessors * 2;
        int blockQueueSize = availProcessors * 3;
        Properties propss = new Properties();
        propss.put("bootstrap.servers", "192.168.119.128:9092");
        propss.put("group.id", "test");
        propss.put("enable.auto.commit", "true");//自动提交offset
        propss.put("auto.commit.interval.ms", "1000");//默认5000ms
        propss.put("session.timeout.ms", "30000");
        propss.put("max.poll.records", threadPoolSize);//每次consumer 拿多少条
        propss.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        propss.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        propss.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");//不同组的consumer 没有提交过offset 从头开始消费
        //propss.put("max.partition.fetch.bytes", "1048576");//从分区获取消息的最大大小 字节 默认 1048576


        final KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(propss);
        Map<String, List<PartitionInfo>> listMaps = kafkaConsumer.listTopics();
        kafkaConsumer.subscribe(Arrays.asList("test"));
        //https://blog.csdn.net/qq_25806863/article/details/71126867
        ThreadPoolExecutor executor = new ThreadPoolExecutor(availProcessors, threadPoolSize, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(blockQueueSize));

        while (true) {
            int activeCount = executor.getActiveCount();
            int threadPoolSizes = executor.getPoolSize();
            int queueSize = executor.getQueue().size();
             logger.info("excuting task:" + activeCount + "   poolSize:" + threadPoolSizes + "   queueSize:" + queueSize + "  核心线程数:" + executor.getCorePoolSize());

            while (blockQueueSize < queueSize + threadPoolSizes) {//可以卡的更死一点  activeCount>0
                queueSize = executor.getQueue().size();//当前队列的内容+线程池的线程 大于 定义的缓存队列数 则等待后面处理完

                //System.out.println("    queueSize + threadPoolSize:" + (queueSize + threadPoolSize));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);//要注意两次poll之间的处理时间 默认是300000ms 超过会触发再平衡  后面处理的耗时较长则需要 谨慎设置

            //records  可能需要用一个list 来中间过渡处理下
            for (final ConsumerRecord<String, String> record : records) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Date dt = new Date(record.timestamp());
                            DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                            String dateTime = df.format(dt);
                           logger.info("offset = {}, value = {}, dateTime={}", record.offset(), record.value(), dateTime);

                            HttpPost httpPost = new HttpPost("http://172.18.23.131:8089");//写到logstash


                            CloseableHttpClient client = HttpClients.createDefault();

                            String json = record.value();
                            StringEntity entity = null;
                            try {
                                entity = new StringEntity(json);
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                            httpPost.setEntity(entity);
                            httpPost.setHeader("Accept", "application/json");
                            httpPost.setHeader("Content-type", "application/json");

                            try {
                                CloseableHttpResponse response = client.execute(httpPost);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }


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
