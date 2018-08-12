package com.example.basejava.Java8.date;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * @author lingjun.jlj
 * @data 2018/5/14
 * @Description:
 */
public class InstantTest {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
        //将java.util.Date转换为Instant
        Instant time = Instant.ofEpochMilli(new Date().getTime());
        //从字符串类型中创建Instant类型的时间
        instant = Instant.parse("1995-10-23T10:12:35Z");
        //将现在的时间加上5个小时4分钟
        instant.plus(Duration.ofHours(5).plusMinutes(4));

    }
}
