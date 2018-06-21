package com.owen;

import com.owen.model.CheckChangeMsg;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * Created by huang_b on 2018/6/19.
 */
public class KafkaProducer {
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.119.128:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 30004);
        props.put("buffer.memory", 33554432);
        props.put("compression.type", "lz4");//gzip，snappy, 或 lz4
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);
        for (int i = 0; i < 10000; i++) {
            CheckChangeMsg checkChangeMsg = new CheckChangeMsg();
            checkChangeMsg.setContent("im content");
            checkChangeMsg.setId(i);

            Future<RecordMetadata> recordMetadataFuture = producer.send(new ProducerRecord<String, String>("test", Integer.toString(i), Integer.toString(i)), new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception e) {
                    if (e != null) {
                        e.printStackTrace();
                    }
                    System.out.println("The offset of the record we just sent is: " + metadata.offset());
                }
            });
        }
        producer.close();
    }
}