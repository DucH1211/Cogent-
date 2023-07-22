package com.microservice.rabbitmq.RabbitMQDemo.controller;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq/consumer")
public class Consumer {
    @Autowired
    private RabbitTemplate template;

}
