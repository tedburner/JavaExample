package com.example.common.generic;

/**
 * @author: lingjun.jlj
 * @date: 2019/6/28 10:29
 * @version：1.0
 * @description:
 */
public class PairTest<K, V> {

    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PairTest{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
