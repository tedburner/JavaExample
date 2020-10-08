package com.example.test;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/16 13:51
 * @description:
 */
public class StringTest {

    public static void main(String[] args) {
        int number = 1000000;
        long tim1 = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            builder.append(i);
        }
        long tim2 = System.currentTimeMillis();
        System.out.println("StringBuilder 耗时:" + (tim2 - tim1) + " ms");

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < number; i++) {
            buffer.append(i);
        }
        long tim3 = System.currentTimeMillis();
        System.out.println("StringBuffer 耗时:" + (tim3 - tim2) + " ms");
    }
}
