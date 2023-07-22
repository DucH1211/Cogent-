package com.producer.Producer.controller;


import com.producer.Producer.classes.CustomMessage;
import com.producer.Producer.configuration.MQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/mq/producer")
public class ProducerRest {
    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publish")
    public String publish(@RequestBody CustomMessage message)
    {
        message.setDate(new Date());
        message.setMessage_id(UUID.randomUUID().toString());
        template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY,message);
        return "Message sent";
    }
}
