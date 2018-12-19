package com.example.common.collections;

import java.util.Vector;

/**
 * @author lingjun.jlj
 * @create 2017-09-18
 **/
public class VectorTest {

    public static void main(String[] args) {
        Vector vector =  new Vector(10,10);
        vector.add("a");
        vector.add("b");
        vector.add("c");
        System.out.println(vector);

    }
}
