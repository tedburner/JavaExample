package com.example.common.concurrent.ThreadLocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/3 14:45
 * @description:
 */
public class TransmittableThreadLocalTest {
    // 使用 TTL，要想传递的值不出问题，线程池必须用TTL 加一层处理
    private static ExecutorService executorService = TtlExecutors
            .getTtlExecutorService(Executors.newFixedThreadPool(2));
    // 采用 TTL 的实现
    private static ThreadLocal tl = new TransmittableThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            String mainThreadName = "main_01";
            tl.set(1);
            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(1), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(1), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(1), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            });

            sleep(1L); //确保上面的会在tl.set执行之前执行
            tl.set(2); // 等上面的线程池第一次启用完了，父线程再给自己赋值

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(2), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(2), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(2), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            });

            System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));
        }).start();

        new Thread(() -> {

            String mainThreadName = "main_02";

            tl.set(3);

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(3), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(3), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(3), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            });

            sleep(1L); //确保上面的会在tl.set执行之前执行
            tl.set(4); // 等上面的线程池第一次启用完了，父线程再给自己赋值

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(4), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(4), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(4), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            });

            System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));

        }).start();

    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
