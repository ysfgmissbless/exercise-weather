package com.demo.report.config;

import com.demo.report.entity.WeatherEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: sending latest weather data to rabbitmq
 * @author: qilong
 * @version: v1.0
 * @date: 2023-02-16 12:51
 */
@Component
public class WeatherSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${application.rabbit.exchanger.name}")
    private String weatherExchangeName;

    /**
     * sending latest weather data to exchange
     *
     * @param weather
     */
    public void send(List<WeatherEntity> weather) {
        rabbitTemplate.convertAndSend(weatherExchangeName, "", weather);
    }
}
