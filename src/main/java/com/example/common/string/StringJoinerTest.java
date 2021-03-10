package com.example.common.string;

import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * @author: lingjun.jlj
 * @date: 2021/2/22 11:22
 * @description: StringJoiner 主要功能是对字符串进行拼接。
 * 比如下面实例，对数组，使用逗号进行分离
 */
public class StringJoinerTest {

    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(",");
        IntStream.range(1, 10)
                .forEach(i -> sj.add(i + ""));
        System.out.println(sj.toString());
    }
}
