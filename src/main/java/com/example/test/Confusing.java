package com.example.test;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/9 14:07
 * @description:
 */
public class Confusing {

    public Confusing(Object obj) {
        System.out.println("object");
    }

    public Confusing(Double[] arr) {
        System.out.println("double array ....");
    }

    public static void main(String[] args) {
        new Confusing(null);
    }
}
