package com.example.redis;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/28 19:48
 * @description:
 */
public class RedisTest {


    public static void main(String[] args) {
        RedisUtils.set("jedis", "test");

        System.out.println(RedisUtils.get("jedis"));
    }
}
