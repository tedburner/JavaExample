package com.example.common.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: lingjun.jlj
 * @date: 2019-04-03 21:28
 * @description: CompletableFuture 异常处理
 */
public class CompletableFutureException {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String name = null;
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> {
                    if (name == null) {
                        throw new RuntimeException("name is null");
                    }
                    return "Hello " + name;
                }).handle((s, t) -> s != null ? s : " Hello,stranger");
        System.out.println(future.get());

        CompletableFuture<Integer> f = CompletableFuture
                .supplyAsync(() -> 7 / 0)
                .thenApply(r -> r * 10)
                .exceptionally(e -> 0);
        System.out.println(f.join());

    }
}
