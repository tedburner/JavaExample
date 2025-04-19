package com.example.test.concurrent;

/**
 * @author: lingjun.jlj
 * @date: 2020/7/30 16:03
 * @description:
 */
public class AddLockDemo {

    volatile int a = 1;
    volatile int b = 1;
    int num = 10000;

    public void add() {
        System.out.println("add start");
        for (int i = 0; i < num; i++) {
            a++;
            b++;
        }
        System.out.println("add done");
    }

    public void compare() {
        System.out.println("compare start");
        for (int i = 0; i < num; i++) {
            if (a < b) {
                System.out.println("a:" + a + ", b:" + b + ", " + (a > b));
            }
        }
        System.out.println("compare done");
    }

    public static void main(String[] args) {
        AddLockDemo demo = new AddLockDemo();
        new Thread(() -> demo.add()).start();
        new Thread(() -> demo.compare()).start();
    }
}
