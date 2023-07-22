package com.wikimedia.wikiconsumer.consumer;

import com.wikimedia.wikiconsumer.entity.WikiDataEvent;
import com.wikimedia.wikiconsumer.repository.WikiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.sql.Clob;

@Service
public class WikiConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WikiConsumer.class.getSimpleName());

    private WikiRepository data_repo;
    @Autowired
    WikiConsumer(WikiRepository data_repo)
    {
        this.data_repo=data_repo;
    }

    @KafkaListener(topics = {"wikimedia.recentchange"}, groupId = "myGroup")
    public void consume(String eventMessage)
    {
        WikiDataEvent event = new WikiDataEvent();
        LOGGER.info(String.format("Message received -> %s",eventMessage));
        event.setMessage(eventMessage);
        data_repo.save(event);
    }
}
