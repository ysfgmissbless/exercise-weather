package com.demo.station.mapper;

import com.demo.station.entity.WeatherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: mapper for w_latest_data table
 * @author: qilong
 * @version: v1.0
 * @date: 2023-02-16 22:19
 */
@Component
@Mapper
public interface WeatherLatestDataMapper {
    /**
     * clean all data
     */
    void deleteAll();

    /**
     * insert latest datas
     * @param weatherEntity
     */
    void insert(@Param("latestData") WeatherEntity weatherEntity);

    /**
     * select latest weather info
     * @return
     */
    List<WeatherEntity> selectAll();
}
