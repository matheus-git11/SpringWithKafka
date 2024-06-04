package com.unicapKafka.SpringWithKafka.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public String publishMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return "Message published successfully";
    }
}






