package com.demo.station.listener;

import com.demo.station.entity.WeatherEntity;
import com.demo.station.mapper.WeatherLatestDataMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: test class for weather info listener
 * @author: qilong
 * @version: v1.0
 * @date: 2023-02-18 11:34
 */
@SpringBootTest
class WeatherDataListenerTest {

    @Autowired
    private WeatherDataListener weatherDataListener;
    @Autowired
    private WeatherLatestDataMapper weatherLatestDataMapper;

    @Test
    void consume() {
        // normal case
        doSuccessTest();
        // temperature is null
        doExceptionTest0();
        // humidity is null
        doExceptionTest1();
        // pressure is null
        doExceptionTest2();
        // cityCode is null
        doExceptionTest3();
    }

    /**
     * demo data
     *
     * @return
     */
    private List<WeatherEntity> demoData() {
        Date currentTime = new Date();
        List datas = new ArrayList<WeatherEntity>();
        WeatherEntity szWeather = new WeatherEntity();
        szWeather.setTemperature(23f);
        szWeather.setHumidity(65f);
        szWeather.setPressure(30.4f);
        szWeather.setCityCode("215002");
        szWeather.setCreateTime(currentTime);
        datas.add(szWeather);

        WeatherEntity wxWeather = new WeatherEntity();
        wxWeather.setTemperature(24f);
        wxWeather.setHumidity(66f);
        wxWeather.setPressure(31.4f);
        wxWeather.setCityCode("215003");
        wxWeather.setCreateTime(currentTime);
        datas.add(wxWeather);

        return datas;
    }

    private void doSuccessTest() {
        // clean table
        weatherLatestDataMapper.deleteAll();
        List<WeatherEntity> emptyList = weatherLatestDataMapper.selectAll();
        Assert.isTrue(emptyList.size() == 0, "bad result");

        // call real method
        List<WeatherEntity> datas = demoData();
        weatherDataListener.consume(datas);

        // check result
        List<WeatherEntity> list = weatherLatestDataMapper.selectAll();
        Assert.notEmpty(list, "bad result");
        Assert.isTrue(list.size() == 2, "bad result");
    }


    private void doExceptionTest0() {
        // clean table
        weatherLatestDataMapper.deleteAll();
        List<WeatherEntity> emptyList = weatherLatestDataMapper.selectAll();
        Assert.isTrue(emptyList.size() == 0, "bad result");

        // call real method
        List<WeatherEntity> datas = demoData();
        datas.get(0).setTemperature(null);
        weatherDataListener.consume(datas);

        // check result
        List<WeatherEntity> list = weatherLatestDataMapper.selectAll();
        Assert.isTrue(list.size() == 0, "bad result");
    }

    private void doExceptionTest1() {
        // clean table
        weatherLatestDataMapper.deleteAll();
        List<WeatherEntity> emptyList = weatherLatestDataMapper.selectAll();
        Assert.isTrue(emptyList.size() == 0, "bad result");

        // call real method
        List<WeatherEntity> datas = demoData();
        datas.get(0).setHumidity(null);
        weatherDataListener.consume(datas);

        // check result
        List<WeatherEntity> list = weatherLatestDataMapper.selectAll();
        Assert.isTrue(list.size() == 0, "bad result");
    }

    private void doExceptionTest2() {
        // clean table
        weatherLatestDataMapper.deleteAll();
        List<WeatherEntity> emptyList = weatherLatestDataMapper.selectAll();
        Assert.isTrue(emptyList.size() == 0, "bad result");

        // call real method
        List<WeatherEntity> datas = demoData();
        datas.get(0).setPressure(null);
        weatherDataListener.consume(datas);

        // check result
        List<WeatherEntity> list = weatherLatestDataMapper.selectAll();
        Assert.isTrue(list.size() == 0, "bad result");
    }

    private void doExceptionTest3() {
        // clean table
        weatherLatestDataMapper.deleteAll();
        List<WeatherEntity> emptyList = weatherLatestDataMapper.selectAll();
        Assert.isTrue(emptyList.size() == 0, "bad result");

        // call real method
        List<WeatherEntity> datas = demoData();
        datas.get(0).setCityCode(null);
        weatherDataListener.consume(datas);

        // check result
        List<WeatherEntity> list = weatherLatestDataMapper.selectAll();
        Assert.isTrue(list.size() == 0, "bad result");
    }
}