package com.example.loadbalance;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: lingjun.jlj
 * @date: 2019/5/9 11:28
 * @description: 负载均衡——随机选择策略
 */
public class RandomLoadBalance {

    public Invoker doSelect(List<Invoker> invokers) {
        int length = invokers.size();
        int firstWeight = invokers.get(0).getWeight();
        int totalWeight = firstWeight;
        //判断所有权重是否相同
        boolean sameWeight = true;
        int[] weights = new int[length];
        for (int i = 1; i < length; i++) {
            int weight = invokers.get(i).getWeight();
            weights[i] = weight;

            //计算总权重
            totalWeight += weight;
            //判断权重是否一致
            if (sameWeight && weight != firstWeight) {
                sameWeight = false;
            }

        }
        //如果总权重大于0，且权重不是一致的
        if (totalWeight > 0 && !sameWeight) {
            int offset = ThreadLocalRandom.current().nextInt(totalWeight);
            for (int i = 0; i < length; i++) {
                offset -= weights[i];
                if (offset < 0) {
                    return invokers.get(i);
                }
            }
        }
        return invokers.get(ThreadLocalRandom.current().nextInt(length));
    }
}
