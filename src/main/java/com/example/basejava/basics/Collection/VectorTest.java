package com.example.basejava.basics.Collection;

import java.util.Vector;

/**
 * @author lingjun.jlj
 * @create 2017-09-18
 **/
public class VectorTest {
    public static final Vector<String> vector = new Vector<>(10,10);

    public static void main(String[] args) {
        vector.add("a");
        vector.add("b");
        vector.add("c");
        System.out.println(vector);

    }
}
