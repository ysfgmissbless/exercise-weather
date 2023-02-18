package com.demo.station.service;

import com.demo.station.entity.WeatherEntity;

import java.util.List;

/**
 * @description: latest weather info service interface
 * @author: qilong
 * @version: v1.0
 * @date: 2023-02-16 22:28
 */
public interface IWeatherLatestDataService {
    /**
     * save latest weather data
     * @param weatherEntity
     */
    void save(List<WeatherEntity> weatherEntity);
}
