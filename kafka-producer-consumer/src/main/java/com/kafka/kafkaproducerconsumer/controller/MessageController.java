package com.kafka.kafkaproducerconsumer.controller;

import com.kafka.kafkaproducerconsumer.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {
    private KafkaProducer kafkaProducer;
    @Autowired
    public MessageController(KafkaProducer kafkaProducer)
    {
        this.kafkaProducer = kafkaProducer;
    }

    /**
     * http://localhost:9050/api/v1/kafka/publish?message=hello-world
     * @return
     */
    @GetMapping("/publish")
    public String publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return "Message sent to topic";
    }
}
