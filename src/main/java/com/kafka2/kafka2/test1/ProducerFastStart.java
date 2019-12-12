package com.kafka2.kafka2.test1;

import com.kafka2.kafka2.entity.UserInfo;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * Kafka 消息生产者
 */
public class ProducerFastStart {
    // Kafka集群地址
    private static final String brokerList = "192.168.72.199:9092";
    // 主题名称-之前已经创建
    private static final String topic = "test";

    public static void main(String[] args) {
        Properties properties = new Properties();
        UserInfo userInfo = new UserInfo();
        userInfo.setId(100);
        userInfo.setName("kafka");
        userInfo.setPhone("111222333");
        userInfo.setAddress("垃圾箱");
        // 设置key序列化器
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //另外一种写法
//        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // 设置重试次数
        properties.put(ProducerConfig.RETRIES_CONFIG, 10);
        // 设置值序列化器
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 设置集群地址
        properties.put("bootstrap.servers", brokerList);
        // KafkaProducer 线程安全
        KafkaProducer<String, Object> producer = new KafkaProducer<>(properties);
        ProducerRecord<String, Object> record = new ProducerRecord<>(topic, "Kafka-demo-001", userInfo);
        try {
            producer.send(record);
            //RecordMetadata recordMetadata = producer.send(record).get();
            //System.out.println("part:" + recordMetadata.partition() + ";topic:" + recordMetadata.topic());
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.close();
    }
}
