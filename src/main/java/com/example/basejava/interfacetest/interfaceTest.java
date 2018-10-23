package com.example.basejava.interfacetest;

/**
 * @author lingjun.jlj
 * @data 2018/3/14
 */
public interface interfaceTest {

    int a = 3;

    final static int b = 4;

    default int sum() {
        return 5;
    }

    static int sum(int a, int b) {
        return 4;
    }

    int sum(int a);

    abstract int sum(int a, float b);//抽象方法可以实现
}
