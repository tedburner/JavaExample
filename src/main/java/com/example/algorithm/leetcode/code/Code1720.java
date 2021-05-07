package com.example.algorithm.leetcode.code;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2021/5/7 21:41
 * @description: 解码异或后的数组
 * 异或特性：
 * 1.异或运算满足交换律和结合律；
 * 2.任意整数和自身做异或运算的结果都等于 0，即 x^x = 0
 * 3.任意整数和 0 做异或运算的结果都等于其自身，即 x ^ 0 = 0 ^ x = x
 */
public class Code1720 {

    public static int[] decode(int[] encoded, int first) {
        int length = encoded.length + 1;
        int[] arr = new int[length];
        arr[0] = first;
        for (int i = 1; i < length; i++) {
            arr[i] = arr[i - 1] ^ encoded[i - 1];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] encoded = new int[]{1, 2, 3};
        int[] arr = decode(encoded, 1);
        System.out.println(Arrays.toString(arr));
    }
}
