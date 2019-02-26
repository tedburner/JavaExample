package com.example.common.jvm.reference;

import java.lang.ref.WeakReference;

/**
 * @author: Arthas
 * @date: 2019-02-26 18:41
 * @description:
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        WeakReference<String> reference = new WeakReference<String>(new String("WeakReference"));
        System.out.println(reference.get());
        System.gc();//通知GVM回收资源
        System.out.println("After GC: ");
        System.out.println(reference.get());
    }
}
