package com.example.common.jvm;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/9 10:39
 * @Description: -XX:+PrintGCDetails
 * // -Xmx2g -Xms2g -Xmn500m -XX:+PrintGCDetails
 * // -XX:+UseConcMarkSweepGC -XX:+PrintHeapAtGC
 */
public class GcCase {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            allocate_1M();
        }
    }

    public static void allocate_1M() {
        byte[] _1M = new byte[1024 * 1000];
    }
}
