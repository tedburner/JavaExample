package com.example.test;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/16 14:03
 * @description:
 */
public class TryCatchTest {

    public static int method() {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}
