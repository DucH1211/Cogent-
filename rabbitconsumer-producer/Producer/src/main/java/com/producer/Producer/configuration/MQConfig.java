package com.producer.Producer.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MQConfig {
    /**
     * Queue id, use through the exchange, binding.
     */
    public static final String QUEUE = "message_queue";
    public static final String EXCHANGE = "message_exchange";
    public static final String ROUTING_KEY = "message_routing_key_new";

    /**
     * creating a {@link Queue} instance with name "message_queue"
     * This is a {@link Bean}
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange exchange()
    {
        return new TopicExchange(EXCHANGE);
    }

    /**
     * This bean is used to bind {@link Queue} with a {@link TopicExchange}
     *
     * @param queue
     * @param exchange
     * @return BindingBuilder.bind().to(exchange).with(routing_key)
     */
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange)
    {
        return BindingBuilder
                .bind(queue).to(exchange).with(ROUTING_KEY);
    }
    @Bean
    public MessageConverter messageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
