package com.example.common.jvm;

import java.util.LinkedList;

/**
 * @author: lingjun.jlj
 * @date: 2019/11/18 21:54
 * @description: 字符串去重
 * -Xmx256M -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 * 去重参数：-XX:+UseStringDeduplication -XX:+PrintStringDeduplicationStatistics
 */
public class StringDepTest {

    private static final LinkedList<String> strings = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        int iteration = 0;
        while (true) {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 10; j++) {
                    strings.add(new String("String " + j));
                }
            }
            iteration++;
            System.out.println("Survived Iteration: " + iteration);
            Thread.sleep(100);
        }

    }
}
