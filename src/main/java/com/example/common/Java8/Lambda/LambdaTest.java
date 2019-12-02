package com.example.common.Java8.Lambda;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author lingjun.jlj
 * @data 2018/4/24
 * @Description: Lambda测试
 */
public class LambdaTest {

    public static List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);

    public static void main(String[] args) {
        list.forEach(System.out::println);
        list.forEach(e -> System.out.println("方式二："+e));
    }
}
