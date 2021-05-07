package com.example.test;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2021/4/30 16:33
 * @description: 计时器 Stopwatch
 */
public class StopwatchTest {

    public static void main(String[] args) throws InterruptedException {
        // 创建并启动 StopWatch
        StopWatch stopwatch = StopWatch.createStarted();
        // 业务逻辑
        Thread.sleep(1000);
        stopwatch.stop();
        System.out.println(stopwatch.getTime(TimeUnit.MILLISECONDS));
    }
}
