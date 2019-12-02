package com.example.common.map;

import com.example.utils.BinaryUtils;

import java.util.Objects;

/**
 * @author: Lucifer
 * @date: 2018-12-19 16:39
 * @description:
 */
public class HashMapHashCase {

    final String key = "";
    final String value = "";
    final int hash = 0;

    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(hash("abc"));
        System.out.println(BinaryUtils.toBinary(hash("abc")));
        System.out.println(BinaryUtils.toBinary(n));
        System.out.println((n - 1) & hash("abc"));
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
