package com.example.test.lock;

/**
 * @author: lingjun.jlj
 * @date: 2020/6/21 19:42
 * @description:
 */
public class LockMissOrCoarseningDemo {

    private static StringBuffer buffer = new StringBuffer();

    public static void main(String[] args) {
        buffer.append("a")
                .append("b")
                .append("c");
        System.out.println(buffer.toString());
    }
}
