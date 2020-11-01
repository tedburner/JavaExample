package com.example.common.concurrent.future;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lingjun.jlj
 * @date: 2019/11/30 23:38
 * @description:
 */
public class CompletionServiceTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);
        //创建 CompletionService
        CompletionService<Integer> service = new ExecutorCompletionService<>(executor);
        //异步向电商S1询价
        service.submit(() -> getPriceByS1());
        //异步向电商S2询价
        service.submit(() -> getPriceByS2());
        //异步向电商S3询价
        service.submit(() -> getPriceByS3());
        //将询价结果异步保存到数据库
        for (int i = 0; i < 3; i++) {
            Integer result = service.take().get();
            executor.execute(() -> System.out.println(result));
        }
    }

    public static Integer getPriceByS1() {
        try {
            Thread.sleep(1000);
            return 100;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Integer getPriceByS2() {
        try {
            Thread.sleep(500);
            return 50;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Integer getPriceByS3() {
        try {
            Thread.sleep(2000);
            return 200;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
