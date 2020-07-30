package com.example.common.java8.lambda;

import java.util.stream.IntStream;

/**
 * @author: lingjun.jlj
 * @date: 2020/7/30 15:39
 * @description: Java8 提供 IntStream、LongStream、DoubleStream。分别表示原始 int 流、原始 long 流、原始 double 流。
 */
public class IntStreamDemo {

    public static void main(String[] args) {
        System.out.println("--Using IntStream.rangeClosed--");
        IntStream.rangeClosed(13, 15).map(n -> n * n).forEach(s -> System.out.print(s + " "));
        System.out.println("\n--Using IntStream.range--");
        IntStream.range(13, 15).map(n -> n * n).forEach(s -> System.out.print(s + " "));
        System.out.println("\n--Sum of range 1 to 10--");
        System.out.print(IntStream.rangeClosed(1, 10).sum());
        System.out.println("\n--Sorted number--");
        IntStream.of(13, 4, 15, 2, 8).sorted().forEach(s -> System.out.print(s + " "));
    }
}
