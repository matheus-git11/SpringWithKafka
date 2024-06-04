package com.unicapKafka.SpringWithKafka.Kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "myTopic", groupId = "myGroup", concurrency = "3")
    public void listen(String message) {
        System.out.println("Received message: " + message + " - Thread: " + Thread.currentThread().getName());
    }
}
