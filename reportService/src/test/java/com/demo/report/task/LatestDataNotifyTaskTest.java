package com.demo.report.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description: test for task
 * @author: qilong
 * @version: v1.0
 * @date: 2023-02-18 7:23
 */
@SpringBootTest
class LatestDataNotifyTaskTest {

    @Autowired
    private LatestDataNotifyTask latestDataNotifyTask;
    @Test
    void notifyStations() {
        latestDataNotifyTask.notifyStations();
    }
}