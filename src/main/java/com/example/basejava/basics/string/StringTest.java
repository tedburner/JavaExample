package com.example.basejava.basics.string;

/**
 * @author lingjun.jlj
 * @data 2018/3/12
 * @description: String、StringBuilder、StringBuffer 性能比较
 */
public class StringTest {

    public static void main(String[] args) {
        int num = 100000;
        String a = "abc";
        long time = System.currentTimeMillis();
        for (int i = 1; i < num; i++) {
            a = a + "hello world";
        }
        System.out.println(System.currentTimeMillis() - time);
        long time1 = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer();
        for (int i = 1; i < num; i++) {
            buffer.append("hello world");
        }
        System.out.println(System.currentTimeMillis() - time1);
        StringBuilder builder = new StringBuilder();
        long time2 = System.currentTimeMillis();
        for (int i = 1; i < num; i++) {
            builder.append("hello world");
        }
        System.out.println(System.currentTimeMillis() - time2);
    }

}
