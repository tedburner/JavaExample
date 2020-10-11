package com.example.common.java8.lambda;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @author lingjun.jlj
 * @date: 2018/4/24
 * @Description: Lambda测试
 */
public class LambdaTest {

    public static List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {
        list.forEach(System.out::println);
        list.forEach(e -> System.out.println("方式二：" + e));

        Predicate<Integer> atLeast5 = x -> x > 5;
        System.out.println(atLeast5.test(6));

        BinaryOperator<Long> addLongs = Long::sum;
        System.out.println(addLongs.apply(1L, 6L));


    }
}
