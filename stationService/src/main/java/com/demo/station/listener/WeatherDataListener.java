package com.demo.station.listener;

import com.alibaba.druid.util.StringUtils;
import com.demo.station.entity.WeatherEntity;
import com.demo.station.service.impl.WeatherLatestDataServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @description: rabbitmq listener for latest data
 * @author: qilong
 * @version: v1.0
 * @date: 2023-02-16 17:38
 */
@Component
public class WeatherDataListener {
    private static final Logger logger = LoggerFactory.getLogger(WeatherDataListener.class);

    @Autowired
    private WeatherLatestDataServiceImpl weatherLatestDataService;

    @RabbitListener(queues = "${application.rabbit.queue.name}")
    public void consume(List<WeatherEntity> weatherList) {
        // validate data
        if (checkMsgData(weatherList)) {
            // save latest weather data
            weatherLatestDataService.save(weatherList);
        }
    }

    /**
     * validate the weather data
     *
     * @param weatherList
     */
    private boolean checkMsgData(List<WeatherEntity> weatherList) {
        if (CollectionUtils.isEmpty(weatherList)) {
            logger.error("msg data is empty");
            return false;
        }

        for (WeatherEntity entity : weatherList) {
            if (null == entity) {
                logger.error("the entity is empty");
                return false;
            }
            if (StringUtils.isEmpty(entity.getCityCode().toString()) || null == entity.getTemperature() || null == entity.getHumidity() || null == entity.getPressure()) {
                logger.error("the three field:cityCode,temperature,humidity,pressure must not be empty,detail Data:{}", entity);
                return false;
            }
        }

        return true;
    }


}
