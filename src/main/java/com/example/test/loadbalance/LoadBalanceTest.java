package com.example.test.loadbalance;

import java.util.Arrays;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2019/5/9 11:49
 * @description:
 */
public class LoadBalanceTest {

    public static void main(String[] args) {
        List<Invoker> invokers = Arrays.asList(
                new Invoker("127.0.0.1:8080", 20),
                new Invoker("127.0.0.1:8081", 10),
                new Invoker("127.0.0.1:8082", 30),
                new Invoker("127.0.0.1:8082", 15));

        for (int i = 0; i < 10000; i++) {
            Invoker invoker = RandomLoadBalance.doSelect(invokers);
            System.out.println(invoker);
        }
    }
}
