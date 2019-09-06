package com.example.common.concurrent.pool;


import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/6 09:28
 * @description: 应用场景：测试当线程异常，是否会抛出堆栈异常；是否会相应别的线程任务，线程是否会放回线程池
 */
public class ExecutorsTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolTaskExecutor executorService = buildThreadPoolTaskExecutor();
        executorService.execute(() -> sayHiError("execute"));
        Thread.sleep(10);
        System.out.println("=====================================");
        Future<?> submit = executorService.submit(() -> sayHi("submit"));
        try {
            submit.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sayHi(String name) {
        String printStr = "【thread-name:" + Thread.currentThread().getName() + ",执行方式:" + name + "】";
        System.out.println(printStr);
        //throw new RuntimeException(printStr + ",我异常啦!哈哈哈!");
    }
    private static void sayHiError(String name) {
        String printStr = "【thread-name:" + Thread.currentThread().getName() + ",执行方式:" + name + "】";
        System.out.println(printStr);
        throw new RuntimeException(printStr + ",我异常啦!哈哈哈!");
    }

    private static ThreadPoolTaskExecutor buildThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
        executorService.setThreadNamePrefix("(线程池-Thread)-");
        executorService.setCorePoolSize(5);
        executorService.setMaxPoolSize(10);
        executorService.setQueueCapacity(1000);
        executorService.setKeepAliveSeconds(30);
        executorService.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executorService.initialize();
        return executorService;
    }
}
