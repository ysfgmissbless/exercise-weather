package com.demo.report.enums;

/**
 * @description: city enum class
 * @author: qilong
 * @version: v1.0
 * @date: 2023-02-17 11:20
 */
public enum CityEnum {
    /**
     * city value
     */
    SUZHOU("215002"), WUXI("215003");

    /**
     * code of city
     */
    private String code;

    public String getCode() {
        return code;
    }

    CityEnum(String code) {
        this.code = code;
    }
}
