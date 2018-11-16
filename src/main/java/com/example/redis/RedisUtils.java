package com.example.redis;

import com.example.utils.redis.JedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Properties;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/28 19:24
 * @description:
 */
public class RedisUtils {

    private static JedisPool jedisPool = null;

    //写成静态代码块形式，只加载一次，节省资源
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        //控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
        // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
        config.setMaxTotal(600);
        //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(300);
        //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setMaxWaitMillis(1000);
        //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        config.setTestOnBorrow(false);
        //jedisPool = new JedisPool(config, "118.25.108.65", 6379, 10000, "redis1230908");
        jedisPool = new JedisPool(config, "192.168.33.120", 6379, 10000, "redis123456");
    }

    /**
     * 从jedis连接池中获取获取jedis对象
     *
     * @return
     */
    private static Jedis getJedis() {
        return jedisPool.getResource();
    }

    private static final JedisUtils jedisUtils = new JedisUtils();


    /**
     * 获取 JedisUtils 实例
     */
    public static JedisUtils getInstance() {
        return jedisUtils;
    }

    public void returnJedis(Jedis jedis) {
        if (null != jedis && null != jedisPool) {
            jedisPool.destroy();
        }
    }

    /**
     * String 插入
     *
     * @param key
     * @param value
     */
    public static void set(String key, String value) {
        Jedis jedis = getJedis();
        jedis.set(key, value);
    }

    /**
     * String 获取
     *
     * @param key
     */
    public static String get(String key) {
        Jedis jedis = getJedis();
        return jedis.get(key);
    }

}
