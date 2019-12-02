package com.example.test;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/16 13:56
 * @description:
 */
public class Demo {
    static Boolean foo(char c) {
        System.out.print(c);
        return true;
    }

    public static void main(String[] args) {
        int i = 0;
        for (foo('A'); foo('B') && (i < 2); foo('C')) {
            i++;
            foo('D');
        }
    }
}
