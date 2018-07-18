package com.owen;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.producer.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Future;

/**
 * Created by huang_b on 2018/6/19.
 */
public class KafkaProducer {
    //https://kafka.apache.org/10/documentation.html#producerconfigs 官网参数说明
    //https://hevodata.com/blog/kafka-exactly-once/   kafka-exactly-once
    static Logger logger = LogManager.getLogger(KafkaProducer.class);

    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.119.128:9092");
        props.put(ProducerConfig.ACKS_CONFIG, "-1");//0表示producer毋须等待leader的确认，1代表需要leader确认写入它的本地log并立即确认，-1代表所有的备份都完成后确认
        props.put("retries", 3);//自0.11.0.0起，Kafka生产者支持幂等传递选项，保证重新发送不会导致日志中重复。
        props.put("max.request.size", 58684289);
        props.put("batch.size", 16384 * 3);//设置一批的大小 预分配
        props.put("linger.ms", 5);//等1s发送一批
        props.put("buffer.memory", 58684289);//这个数据（大于单条消息） 基本上是producer使用的内存总大小   还有一些额外的维护请求和压缩的内存
        props.put("compression.type", "lz4");//gzip，snappy, 或 lz4
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("enable.idempotence", "true");// 开启写入消息时的幂等性  只针对单分区  单会话  针对多分区 要开启事务  开启后会影响 写效率
        //props.put("transcational.id", "89789");//保证发送多分区消息 原子性


        // 推荐使用单例 线程安全 可是如果挂了  就都没用了， 多例的粒度更细 内存也会多
        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);
        System.out.println(new Date());
        String msgFromFile = readFileLine();
        //for (int j = 0; j < 40; j++) {
        for (int i = 0; i < 700; i++) {

            String msg = JSON.toJSONString(props);
            msg = msgFromFile;
            //msg="{\"coreThreadNum\":20,\"excutingTask\":0,\"id\":0,\"poolSize\":0,\"queueSize\":0}\n";
            //new callback
            Future<RecordMetadata> recordMetadataFuture = producer.send(new ProducerRecord<String, String>("test", Integer.toString(i), msg), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    logger.info("offset:" + recordMetadata.offset() + "  serializedValueSize:" + recordMetadata.serializedValueSize());
                }
            });

        }
        // Thread.sleep(1000);
        //}
        producer.close();
        System.out.println(new Date());
    }

    private static String readFileLine() {
        //这是一个50M的json文本
        File file = new File("D:\\logs\\testkafka.txt");
        BufferedReader reader = null;
        String msg = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                //System.out.println("line " + line + ": " + tempString);
                msg = tempString;
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return msg;

    }
}