package com.example.common.concurrent.future;

import java.util.concurrent.CompletableFuture;

/**
 * @author: Arthas
 * @date: 2019-03-22 13:45
 * @description: CompletableFuture 测试类
 */
public class CompletableFutureTest {

    public static void main(String[] args) {


        String result = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        }).thenApplyAsync(v -> v + " world !!!!").join();

        System.out.println(result);


        String result1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }), (s1, s2) -> {
            return s1 + " " + s2;
        }).join();
        System.out.println(result1);
    }
}
