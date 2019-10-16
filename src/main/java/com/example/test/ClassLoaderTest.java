package com.example.test;

/**
 * @author: lingjun.jlj
 * @date: 2019/10/15 21:18
 * @description:
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader: " + loader);
        System.out.println("parent loader:" + loader.getParent());
        System.out.println("grandparent loader:" + loader.getParent().getParent());
    }

}
