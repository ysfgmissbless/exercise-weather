package com.demo.station.service.impl;

import com.demo.station.entity.WeatherEntity;
import com.demo.station.mapper.WeatherLatestDataMapper;
import com.demo.station.service.IWeatherLatestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: latest weather info implement class
 * @author: qilong
 * @version: v1.0
 * @date: 2023-02-16 22:29
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WeatherLatestDataServiceImpl implements IWeatherLatestDataService {

    @Autowired
    private WeatherLatestDataMapper weatherLatestDataMapper;

    /**
     * save latest weather data
     *
     * @param weathers
     */
    @Override
    public void save(List<WeatherEntity> weathers) {
        // delete record
        weatherLatestDataMapper.deleteAll();
        // insert record
        for (WeatherEntity entity : weathers) {
            weatherLatestDataMapper.insert(entity);
        }
    }
}
