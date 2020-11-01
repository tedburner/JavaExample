package com.example.common;

/**
 * @author: lingjun.jlj
 * @date: 2018-11-28 16:33
 * @description: 运算符
 */
public class OperationalCharacterTest {

    public static void main(String[] args) {
        // << 左移一位，相当于乘2
        System.out.println(4 << 1);

        // >> 右移一位，相当于除以2
        System.out.println(4 >> 1);

        // >>> 无符号右移
        System.out.println(4 >>> 1);

        // |= 类似于 += 这样的写法
        boolean flag = true;
        flag |= true;
        System.out.println(flag);

        // &=
        flag &= false;
        System.out.println(flag);
    }
}
