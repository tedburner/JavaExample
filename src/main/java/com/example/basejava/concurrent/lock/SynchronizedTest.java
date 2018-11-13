package com.example.basejava.concurrent.lock;

/**
 * @author: Lucifer
 * @date: 2018/11/13 18:10
 * @description:
 * 查看字节码命令：javac SynchronizedTest.java    javap -c -s -v -l  SynchronizedTest
 */
public class SynchronizedTest {

    public synchronized void doSth() {
        System.out.println("doSth");
    }

    public void method() {
        synchronized (SynchronizedTest.class) {
            System.out.println("method");
        }
    }
}
