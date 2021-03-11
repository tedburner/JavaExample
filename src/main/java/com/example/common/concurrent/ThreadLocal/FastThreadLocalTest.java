package com.example.common.concurrent.ThreadLocal;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/4 15:52
 * @description: netty对Thread进行了优化 {@link io.netty.util.concurrent.FastThreadLocal}。
 * 线程需要使用 {@link io.netty.util.concurrent.FastThreadLocalThread}，如果使用 Thread，会退化成 ThreadLocal。
 * FastThreadLocal 有ThreadLocal中的threadLocalHashCode进行了优化
 * <p>
 * 每一个FastThreadLocal实例创建时，分配一个下标index；分配index使用AtomicInteger实现，每个FastThreadLocal都能获取到一个不重复的下标。
 * 当调用ftl.get()方法获取值时，直接从数组获取返回，如return array[index]
 */
public class FastThreadLocalTest {

    final static ThreadLocal<String> tl = new ThreadLocal<>();
    final static FastThreadLocal<String> ftl = new FastThreadLocal<>();

    public static void main(String[] args) {
        tl.set("ThreadLocal");
        ftl.set("FastThreadLocal");

        new FastThreadLocalThread(() -> {
            System.out.println("Parent ThreadLocal value is " + tl.get());
            System.out.println("Parent FastThreadLocal value is " + ftl.get());
        }).start();

    }
}
