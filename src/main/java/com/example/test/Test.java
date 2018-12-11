package com.example.test;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/15 21:25
 * @description:
 */
public class Test {

    public static void main(String[] args) {
//        Object[] elementData  =new Object[10];
//        int elementCount = 2;
//        int index = 1;
//        Object obj = "vector";
//        Object obj1 = "vector1";
//
//        elementData[0] = obj;
//        elementData[1] = obj;
//        elementData[2] = obj1;
//        elementData[3] = obj;
//        System.arraycopy(elementData, index, elementData, index + 1, elementCount - index);
//        System.out.print(elementData.toString());

        System.out.println(System.currentTimeMillis());


        int n = 9 - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        System.out.println(n);

        String a = "123";
        String b = "123";
        System.out.println(a == b);


    }
}
