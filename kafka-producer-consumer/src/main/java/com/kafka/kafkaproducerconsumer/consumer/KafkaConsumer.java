package com.kafka.kafkaproducerconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = {"test-topic"},groupId = "myGroup")
    public void consume(String message)
    {
        LOGGER.info(String.format("Message received -> %s",message));
    }
}
