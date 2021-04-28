package com.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/25 10:09
 * @description:
 */
public class Test {

    public static void main(String[] args) throws Exception {
        String content = "||法外狂徒张三||||法外狂徒张三|333333333333333|931.200000|2528561619508462021|001|1|202104|1|全部成功|20210427000000||分账";
        String[] array = content.split("\\|");
        // 流水号
        String serialNo = array[9];
        // 发放状态，1成功，0失败
        String status = array[13];
        // 失败原因
        String failReason = array[14];
        // 发放时间
        String completeTime = array[15];
        System.out.println(serialNo);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime time = LocalDateTime.of(now.toLocalDate(), LocalTime.MAX);
        System.out.println(time);
    }
}
