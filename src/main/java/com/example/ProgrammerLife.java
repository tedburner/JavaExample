package com.example;

/**
 * @author: Arthas
 * @date: 2019-01-11 11:21
 * @description: 程序员的医生
 */
public class ProgrammerLife {

    private static Boolean alive = true;

    public static void main(String[] args) {
        while (alive) {
            eat();
            code();
            //sleep();
        }
    }

    private static void eat() {
        System.out.println("吃。。。。。");
    }

    private static void code() {
        System.out.println("码代码。。。。。");
    }

    private  void sleep() {
        System.out.println("休养生息。。。。。");
    }
}
