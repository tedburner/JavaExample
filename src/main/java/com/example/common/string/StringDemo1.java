package com.example.common.string;

/**
 * @author: Lucifer
 * @date: 2018/11/14 13:57
 * @description: String 对象 demo
 * 这里下面的new String 创建了一个，abc 是从常量池中获取的
 */
public class StringDemo1 {

    public static void main(String[] args) {
        String s1 = "abc";
        String s = new String("abc");
        System.out.println(s == s1);
    }
}
