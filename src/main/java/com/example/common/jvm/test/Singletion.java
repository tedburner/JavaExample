package com.example.common.jvm.test;

/**
 * @author: lingjun.jlj
 * @date: 2019/3/31 0031 18:23
 * @description:
 */
public class Singletion {

    private Singletion(){

    }

    private static class LazyHolder{
        static final Singletion INSTANCE = new Singletion();
        static {
            System.out.println("LazyHolder.<clinit>");
        }
    }
    public static Object getInstance(boolean flag){
        if (flag) return new LazyHolder[2];
        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {
        getInstance(true);
        System.out.println("----------------");
        getInstance(false);

    }
}
