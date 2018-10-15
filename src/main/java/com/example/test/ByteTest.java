package com.example.test;

/**
 * @author: 蒋灵俊
 * @Date: 2018/6/8 14:58
 * @Description:
 */
public class ByteTest {

    public static void main(String[] args) {
        String str = "\r\n";
        byte[] bs = str.getBytes();
        System.out.println(bs);
    }
}
