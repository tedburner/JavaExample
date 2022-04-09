package com.example.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2018-12-12 22:22
 * @description: google guava cache
 */
public class GuavaCacheCase {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //google guava cache CacheBuilder的构造函数是私有的，在智能通过静态方法 newBuilder 来获取 CacheBuilder 实例
        LoadingCache<Integer, String> cache = CacheBuilder.newBuilder()
                //设置并发级别为8，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(8)
                //设置写缓存后8秒过期
                .expireAfterWrite(8, TimeUnit.SECONDS)
                //设置初始容量 10
                .initialCapacity(10)
                //设置缓存最大容量为100，超过100之后就会按照 LRU 最近最少使用算法来移除缓存
                .maximumSize(100)
                //定时刷新数据
                .refreshAfterWrite(1, TimeUnit.SECONDS)
                //设置要统计缓存的命中率
                .recordStats()
                //设置缓存移除通知
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey() + " was removed, cause is" + notification.getCause());
                    }
                })
                .build(
                        //build 方法可以指定CacheLoader，在缓存不存在是通过CacheLoader的实现自动加载缓存
                        new CacheLoader<Integer, String>() {
                            @Override
                            public String load(Integer key) throws Exception {
                                System.out.println("load data: " + key);
                                String str = key + ":cache-value";
                                return str;
                            }
                        }
                );
        for (int i = 0; i < 20; i++) {
            String str = cache.get(1);
            System.out.println(str);
            //休眠一秒
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("cache status:");

        System.out.println(cache.stats().toString());
    }
}
