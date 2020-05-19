package com.example.common.jvm.reference;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2020/5/19 21:49
 * @description: 软引用: 当内存不够时，会进行GC
 * -Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails
 */
public class SoftReferenceDemo {

    public static void main(String[] args) {
        List<SoftReference<byte[]>> list = new LinkedList<>();
        for (int i = 0; i < 21; i++) {
            SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024]);
            list.add(softReference);
            System.out.println("gc 前：" + softReference.get());
        }
        System.gc();
        for (SoftReference<byte[]> softReference : list) {
            System.out.println("gc 后：" + softReference.get());
        }
    }
}
