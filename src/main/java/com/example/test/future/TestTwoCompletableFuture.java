package com.example.test.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/31 23:40
 * @description: 多个CompletableFuture进行组合运算
 */
public class TestTwoCompletableFuture {

    public static CompletableFuture<String> doSomethingOne(String encodedCompanyId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return encodedCompanyId;
        });
    }

    public static CompletableFuture<String> doSomethingTwo(String companyId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return companyId + ":alibaba";
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture result = doSomethingOne("123")
                .thenCompose(id -> doSomethingTwo(id));
        System.out.println(result.get());

        CompletableFuture result1 = doSomethingOne("123")
                .thenCombine(doSomethingTwo("456"), (one, two) -> one + " " + two);
        System.out.println(result1.get());
    }
}
