package com.kafka.kafkaproducerconsumer.producer;

import com.kafka.kafkaproducerconsumer.classes.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String,String> kafkaTemplate;//use for send and receive
    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String message)
    {
        LOGGER.info(String.format("Message sent to %s",message));
        kafkaTemplate.send(Constants.TOPIC_NAME,message);
    }
}
