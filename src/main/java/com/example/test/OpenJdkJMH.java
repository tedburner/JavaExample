package com.example.test;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Calendar;

/**
 * @author: lingjun.jlj
 * @Date: 2018/6/27 14:16
 * @Description: JMH是一个Java工具，用于构建、运行和分析基于JVM的（纳秒/微秒/毫秒/宏）基准测试。
 * 基准测试可以用Java或其他语言编写。
 */
public class OpenJdkJMH {

    static int millis = 24 * 3600 * 1000;

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(OpenJdkJMH.class.getName())
                .forks(1)
                .build();
        new Runner(options)
                .run();

    }

    public String method(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte aByte : bytes) {
            builder.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }
        return builder.toString();
    }


    @Benchmark
    @Threads(5)
    public void runCalendar() {
        Calendar calendar = Calendar.getInstance();
    }


    @Benchmark
    @Threads(5)
    public void runSystem() {
        long result = System.currentTimeMillis() / millis;
        System.out.println("runSystem" + result);
    }

}
