package com.example.test;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/9 15:09
 * @description: java 传值引用，而不是
 */
public class Swap {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        swap(num1, num2);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
