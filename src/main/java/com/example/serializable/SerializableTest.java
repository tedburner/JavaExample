package com.example.serializable;

import com.example.serializable.hessian.HessianTest;
import com.example.serializable.kryo.KryoTest;

/**
 * @author: lingjun.jlj
 * @date: 2019-01-14 16:17
 * @description:
 */
public class SerializableTest {

    public static void main(String[] args) {
        KryoTest kryo = new KryoTest();
        System.out.println((String) kryo.deserialize(kryo.serialize("Kryo 序列化。。。。")));


        HessianTest hessian = new HessianTest();
        System.out.println((String)hessian.deserialize(hessian.serialize("Hessian 序列化。。。")));
    }
}
