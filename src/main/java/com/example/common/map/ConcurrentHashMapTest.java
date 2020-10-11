package com.example.common.map;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author lingjun.jlj
 * @date: 2018/5/1
 * @Description: ConcurrentHashMap 只保证
 */
public class ConcurrentHashMapTest {

    //线程个数
    private static int THREAD_COUNT = 10;
    //总元素数量
    private static int ITEM_COUNT = 1000;

    //帮助方法，用来获得一个指定元素数量模拟数据的ConcurrentHashMap
    public static ConcurrentHashMap getData(int count) {
        return LongStream.rangeClosed(1, count)
                .boxed()
                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(), Function.identity(), (o1, o2) -> o1, ConcurrentHashMap::new));
    }

    public static void main(String[] args) throws InterruptedException {
        Map<String, Long> map = getData(ITEM_COUNT - 100);
        System.out.println("init size: " + map.size());

        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        //使用线程池并发处理逻辑
        forkJoinPool.execute(() -> {
            IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
                //查询还要补充多少元素
                int gap = ITEM_COUNT - map.size();
                System.out.println("gap size: " + gap);
                map.putAll(getData(gap));
            });
        });
        //等待所有任务完成
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        //最后元素个数
        System.out.println("finish size: " + map.size());
    }
}
