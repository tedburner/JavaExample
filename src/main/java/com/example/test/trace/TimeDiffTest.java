package com.example.test.trace;

import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2021/1/14 09:24
 * @description:
 */
public class TimeDiffTest {

    public static void main(String[] args) throws InterruptedException {
        final long startMs = TimeUtils.nowMs();

        TimeUnit.SECONDS.sleep(5); // 模拟业务代码

        System.out.println("timeCost: " + TimeUtils.diffMs(startMs));
    }
}
