package com.example.loadbalance;

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
                new Invoker("A", "dubbo://10.121.135.25:20880/DemoService/sayHello", "dubbo://10.121.135.25:20880/DemoService", 1),
                new Invoker("B", "dubbo://10.121.135.26:20880/DemoService/sayHello", "dubbo://10.121.135.26:20880/DemoService", 3),
                new Invoker("C", "dubbo://10.121.135.27:20880/DemoService/sayHello", "dubbo://10.121.135.27:20880/DemoService", 5));

        //随机策略
//      RandomLoadBalance balance = new RandomLoadBalance();
        //轮询策略
        RoundRobinLoadBalance balance = new RoundRobinLoadBalance();
        for (int i = 0; i < 10; i++) {
            Invoker invoker = balance.doSelect(invokers);
            System.out.println(invoker.getName() + " 方法权重：" + invoker.getWeight());
        }
    }
}
