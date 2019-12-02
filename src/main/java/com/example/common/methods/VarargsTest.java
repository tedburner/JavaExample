package com.example.common.methods;

/**
 * @author: Lucifer
 * @date: 2018/11/19 15:00
 * @description:
 */
public class VarargsTest {

    public static void main(String[] args) {
        int count = sum(1, 2, 3, 4);
        System.out.println(count);

    }

    public static int sum(int... args) {
        int count = 0;
        for (int arg : args) {
            count += arg;
        }
        return count;
    }
}
