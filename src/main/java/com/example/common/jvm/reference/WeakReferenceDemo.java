package com.example.common.jvm.reference;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2019-02-26 18:41
 * @description: 弱引用，只能存活到下一次GC
 * -Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        List<WeakReference<byte[]>> list = new LinkedList<>();
        for (int i = 0; i < 21; i++) {
            WeakReference<byte[]> weakReference = new WeakReference<>(new byte[1024 * 1024]);
            list.add(weakReference);
            System.out.println("gc 前：" + weakReference.get());
        }
        System.gc();
        for (WeakReference<byte[]> weakReference : list) {
            System.out.println("gc 后：" + weakReference.get());
        }
    }
}
