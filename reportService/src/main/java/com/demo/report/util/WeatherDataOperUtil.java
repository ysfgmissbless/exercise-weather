package com.demo.report.util;

import com.demo.report.entity.WeatherEntity;
import com.demo.report.enums.CityEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: tool class for operating weather data
 * @author: qilong
 * @version: v1.0
 * @date: 2023-02-16 13:56
 */
public class WeatherDataOperUtil {
    /**
     * get the latest weather Data
     *
     * @return
     */
    public static List getLatestWeather() {
        // TODO call api or mysql to get latest weather data
        // demo data
        List datas = new ArrayList<WeatherEntity>();
        WeatherEntity szWeather = new WeatherEntity();
        szWeather.setTemperature(23f);
        szWeather.setHumidity(65f);
        szWeather.setPressure(30.4f);
        szWeather.setCityCode(CityEnum.SUZHOU.getCode());
        szWeather.setCreateTime(new Date());
        datas.add(szWeather);

        WeatherEntity wxWeather = new WeatherEntity();
        wxWeather.setTemperature(24f);
        wxWeather.setHumidity(66f);
        wxWeather.setPressure(31.4f);
        wxWeather.setCityCode(CityEnum.WUXI.getCode());
        wxWeather.setCreateTime(new Date());
        datas.add(wxWeather);
        return datas;
    }
}
