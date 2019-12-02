package com.example.test;

/**
 * @author: lingjun.jlj
 * @date: 2019/6/21 11:45
 * @version：1.0
 * @description:
 */
public class PrintExpectionStackTest {


    public static void main(String[] args) {
        for (Long i = 0L; i < 1000000000000L; i++) {
            try {
                int a = 10 / 0;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
