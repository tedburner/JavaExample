package com.example.basejava.basics.concurrent.ThreadLocal;

/**
 * @author lingjun.jlj
 * @data 2018/4/24
 * @Description:
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal();
        local.set("1");
        String a = local.get();
        System.out.println(a);
    }
}
