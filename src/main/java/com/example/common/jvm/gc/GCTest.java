package com.example.common.jvm.gc;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 15:22
 * @description:  -XX:+PrintGCDetails
 */
public class GCTest {

    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        //allocation1 = new byte[30900*1024];
        allocation2 = new byte[900*1024];
    }
}
