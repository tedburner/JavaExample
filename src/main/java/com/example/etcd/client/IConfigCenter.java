package com.example.etcd.client;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/29 14:17
 * @description:
 */
public interface IConfigCenter {

    /**
     * 存储元素
     *
     * @param key
     * @param value
     */
    void put(String key, String value);

    /**
     * 获取数据
     *
     * @param key
     * @return
     */
    String get(String key);
}
