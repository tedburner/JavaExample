package com.example.common.string;

/**
 * @author: Lucifer
 * @date: 2018/11/14 13:57
 * @description: String 对象 demo
 * 关于 String s = new String("abc"); 创建了几个对象的问题？
 * 创建了2个对象，常一个是new  String 创建的一个新的对象，一个是常量“abc”对象的内容创建出的一个新的String对象，
 * 注意：不推荐使用这种方法创建 String 对象
 */
public class StringDemo {

    public static void main(String[] args) {
        //String s = new String("abc");
        String s1 = "abc";
    }
}
