package com.demo.report.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: weather info model
 * @Author: qilong
 * @version: v1.0
 * @Date: 2023/02/06 13:00
 */
@Data
public class WeatherEntity {
    /**
     * city code(take jiangsu for example)
     */
    private String cityCode;

    /**
     * temperature
     */
    private Float temperature;

    /**
     * humidity
     */
    private Float humidity;

    /**
     * pressure
     */
    private Float pressure;

    /**
     * createTime
     */
    private Date createTime;
}
