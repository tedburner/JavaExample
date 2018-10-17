package com.example.basejava.concurrent.ThreadLocal;


import java.util.ArrayList;
import java.util.List;

/**
 * @author lingjun.jlj
 * @data 2018/4/24
 * @Description: ThreadLocal 例子
 */
public class ThreadLocalTest {

    public static ThreadLocal<List<String>> threadLocal = new ThreadLocal<>();

    public static void setThreadLocal(List<String> values) {
        threadLocal.set(values);
    }

    public void getThreadLocal() {
        System.out.println(Thread.currentThread().getName());
        threadLocal.get().forEach(name -> System.out.println(name));
    }

    public static void main(String[] args) {
        final ThreadLocalTest threadLocalTest = new ThreadLocalTest();

        new Thread(() -> {
            List<String> params = new ArrayList<>(3);
            params.add("蒋先森");
            params.add("康发明");
            params.add("张三");
            threadLocalTest.setThreadLocal(params);
            threadLocalTest.getThreadLocal();
        }).start();

        new Thread(() -> {
            List<String> params = new ArrayList<>(2);
            params.add("中国");
            params.add("英国");
            threadLocalTest.setThreadLocal(params);
            threadLocalTest.getThreadLocal();
        }).start();

    }
}
