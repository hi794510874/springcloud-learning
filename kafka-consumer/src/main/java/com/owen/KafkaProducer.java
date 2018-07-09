package com.owen;

import com.owen.model.CheckChangeMsg;
import org.apache.commons.logging.Log;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.Future;
import java.util.logging.LogManager;

/**
 * Created by huang_b on 2018/6/19.
 */
public class KafkaProducer {
    private static Logger logger= LoggerFactory.getLogger(KafkaProducer.class);
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.119.128:9092");
        props.put("acks", "all");//等到所有的副本响应后 才认为写入成功 最高保障
        props.put("retries", 3);//自0.11.0.0起，Kafka生产者支持幂等传递选项，保证重新发送不会导致日志中重复。
        props.put("batch.size", 16384);
        props.put("linger.ms", 30004);
        props.put("buffer.memory", 33554432);
        props.put("compression.type", "lz4");//gzip，snappy, 或 lz4
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("enable.idempotence", "true");// 开启写入消息时的幂等性  只针对单分区  单会话  针对多分区 要开启 事务
        //props.put("transcational.id", "设置上面的开启幂等性，然后设置事务id 才能最终开启事务");//保证发送多分区消息 原子性



        // 推荐使用单例 线程安全
        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);

        for (int i = 0; i < 1000; i++) {

            Future<RecordMetadata> recordMetadataFuture = producer.send(new ProducerRecord<String, String>("test", Integer.toString(i), "{\"TraceId\":\"40439010-f259-4990-8bf8-459fc676584f\",\"CatKey\":{\"MemberId\":0,\"MotoGuid\":\"\",\"OrderId\":\"\"},\"LevelID\":1}"), new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception e) {
                    if (e != null) {
                        e.printStackTrace();
                    }

                    logger.info("The offset of the record we just sent is: " + metadata.offset());
                }
            });
        }
        producer.close();
    }
}