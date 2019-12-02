package com.example.test;

import java.text.SimpleDateFormat;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/30 11:44
 * @version：1.0.0
 * @description:
 */
public class ComputeTime {
    public static void main(String[] args) throws Exception {
        Integer time = 70;
        Integer hour = time /3600;
        time = time % 3600;
        Integer minute = time / 60;
        Integer second = time % 60;

        System.out.println(String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second));
    }
}
