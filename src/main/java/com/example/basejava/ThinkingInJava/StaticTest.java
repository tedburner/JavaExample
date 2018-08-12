package com.example.basejava.ThinkingInJava;

/**
 * @author lingjun.jlj
 * @data 2018/5/1
 * @Description:
 */
public class StaticTest {

    private static String a = "Hello";
    private String b = "world";

    public static void tset2(){
        System.out.println(a);
        //System.out.println(b);
        StaticTest test = new StaticTest();
        System.out.println(test.b);


    }

    public static void main(String[] args) {

    }
}
