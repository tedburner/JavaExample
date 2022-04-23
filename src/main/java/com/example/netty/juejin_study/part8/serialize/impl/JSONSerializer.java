package com.example.netty.juejin_study.part8.serialize.impl;

import com.alibaba.fastjson2.JSON;
import com.example.netty.juejin_study.part8.serialize.Serializer;
import com.example.netty.juejin_study.part8.serialize.SerializerAlgorithm;

/**
 * @author: lingjun.jlj
 * @date: 2019-01-11 13:58
 * @description:
 */
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
