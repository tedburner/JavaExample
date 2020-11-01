package com.example.test.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author: lingjun.jlj
 * @date: 2020/11/1 16:27
 * @description:
 */
public class StreamTestFuture {

    public static String rpcCall(String ip, String param) {
        System.out.println(ip + " rpc call: " + param);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return param;
    }

    public static void main(String[] args) {
        List<String> ipList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            ipList.add("192.168.0." + i);
        }
        long start = System.currentTimeMillis();
        List<String> result = new ArrayList<>();
        for (String ip : ipList) {
            result.add(rpcCall(ip, ip));
        }
        result.forEach(System.out::println);
        System.out.println("cost: " + (System.currentTimeMillis() - start) + " ms");

        long startTime = System.currentTimeMillis();
        //并发调用
        List<CompletableFuture<String>> futureList = ipList.stream()
                .map(ip -> CompletableFuture.supplyAsync(() -> rpcCall(ip, ip)))
                .collect(Collectors.toList());
        //等待所以异步任务执行完毕
        List<String> resultList = futureList.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        resultList.forEach(System.out::println);
        System.out.println("CompletableFuture cost: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
