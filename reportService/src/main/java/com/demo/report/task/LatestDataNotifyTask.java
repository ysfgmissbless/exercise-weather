package com.demo.report.task;

import com.demo.report.config.WeatherSender;
import com.demo.report.entity.WeatherEntity;
import com.demo.report.util.WeatherDataOperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: schedule task to provide latest weather data to mq every minute
 * @author: qilong
 * @version: v1.0
 * @date: 2023-02-16 13:14
 */
@Component
@EnableScheduling
@ConditionalOnProperty(name = "application.task.latestDataNotifyTask.status", havingValue = "1")
public class LatestDataNotifyTask {
    private static final Logger logger = LoggerFactory.getLogger(LatestDataNotifyTask.class);
    @Autowired
    private WeatherSender weatherSender;

    @Scheduled(cron = "${application.task.latestDataNotifyTask.cron}")
    public void notifyStations() {
        // get the latest weather data
        List<WeatherEntity> latestWeather = WeatherDataOperUtil.getLatestWeather();

        logger.info("------------start send--------------");
        logger.info("Send Data{}", latestWeather);
        // send to rabbit
        weatherSender.send(latestWeather);
        logger.info("------------end send--------------");
    }
}
