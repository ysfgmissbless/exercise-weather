package com.demo.station.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: rabbitmq configuration
 * @author: qilong
 * @version: v1.0
 * @date: 2023-02-16 16:14
 */
@Configuration
public class RabbitConfig {
    @Value("${application.rabbit.exchanger.name}")
    private String weatherExchangeName;
    @Value("${application.rabbit.queue.name}")
    private String weatherQueueName;

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue stationQueue() {
        return new Queue(weatherQueueName, true, false, false);
    }

    @Bean
    public FanoutExchange weatherFanoutExchange() {
        return new FanoutExchange(weatherExchangeName, true, false);
    }

    @Bean
    public Binding bindingStationQueue(Queue stationQueue, FanoutExchange weatherFanoutExchange) {
        return BindingBuilder.bind(stationQueue).to(weatherFanoutExchange);
    }
}
