package com.wikimedia.kafkaproject.wikiproducer.eventhandler;

import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;


public class WikimediaEventHandler implements BackgroundEventHandler {
    KafkaTemplate<String,String> kafkaTemplate;
    String topic;
    private final Logger LOGGER = LoggerFactory.getLogger(WikimediaEventHandler.class.getSimpleName());
    @Autowired
    public WikimediaEventHandler(KafkaTemplate<String,String>kafkaTemplate,String topic)
    {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }
    @Override
    public void onOpen() throws Exception {
        //nothing here
    }

    @Override
    public void onClosed() throws Exception {
        //nothing here
    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info(messageEvent.getData());
        //send the message to kafka.
        kafkaTemplate.send(new ProducerRecord<>(topic, messageEvent.getData()));
    }

    @Override
    public void onComment(String s) throws Exception {
        //nothing here
    }

    @Override
    public void onError(Throwable throwable) {
        LOGGER.error("Error in Stream Reading",throwable);
    }
}
