package com.example.basejava.string;

/**
 * @author: Lucifer
 * @date: 2018/11/14 13:57
 * @description: String 对象 demo
 * 关于 String s = new String("abc"); 创建了几个对象的问题？
 * 创建了2个对象，常量池中一个对象，在堆内存中也有一个对象。new String("abc")的时候，
 * 在内存堆里面创建了一个，String s 定义的时候创建了一个，最后 s 指向了  abc 的地址。
 * 注意：不推荐使用这种方法创建 String 对象
 */
public class StringDemo {

    public static void main(String[] args) {
        String s = new String("abc");
        String s1 = "abc";

        System.out.println(s == s1);
    }
}
