package com.wikimedia.kafkaproject.wikiproducer.producer;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.StreamException;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import com.wikimedia.kafkaproject.wikiproducer.eventhandler.WikimediaEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaProducer {
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public WikimediaProducer(KafkaTemplate<String,String> kafkaTemplate)
    {
        this.kafkaTemplate=kafkaTemplate;
    }
    public void sendMessage() throws InterruptedException, StreamException {
        String topic = "wikimedia.recentchange";
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        BackgroundEventHandler eventHandler = new WikimediaEventHandler(kafkaTemplate,topic);
        BackgroundEventSource.Builder builder = new BackgroundEventSource
                .Builder(
                        eventHandler, new EventSource.Builder(URI.create(url))
        );
        BackgroundEventSource backgroundEventSource = builder.build();
        //eventsource is used for processing of stream.
        backgroundEventSource.start();

        TimeUnit.MINUTES.sleep(1);
    }
}
