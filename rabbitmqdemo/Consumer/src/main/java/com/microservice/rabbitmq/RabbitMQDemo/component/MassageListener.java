package com.microservice.rabbitmq.RabbitMQDemo.component;

import com.microservice.rabbitmq.RabbitMQDemo.classes.CustomMessage;
import com.microservice.rabbitmq.RabbitMQDemo.configuration.MQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MassageListener {
    @RabbitListener(queues = {MQConfig.QUEUE,"message_queue1"})
    public void listener(CustomMessage customerMessage)
    {
        System.out.println(customerMessage);
    }
}
