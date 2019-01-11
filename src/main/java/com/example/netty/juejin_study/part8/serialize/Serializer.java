package com.example.netty.juejin_study.part8.serialize;

import com.example.netty.juejin_study.part8.serialize.impl.JSONSerializer;

/**
 * @author: Arthas
 * @date: 2019-01-11 13:57
 * @description:
 */
public interface Serializer {

    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     */
    byte getSerializerAlgorithm();

    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
