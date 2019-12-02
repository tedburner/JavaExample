package com.example.test;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/9 13:51
 * @version：1.0
 * @description: Integer.MAX_VALUE +1 变负数了，循环陷入死循环
 */
public class Loopy {
    public static void main(String[] args) {
        final int start = Integer.MAX_VALUE - 100;
        final int end = Integer.MAX_VALUE;

        System.out.println(end + 1);
        int count = 0;
        for (int i = start; i <= end; i++)
            count++;
        System.out.println(count);
    }
}
