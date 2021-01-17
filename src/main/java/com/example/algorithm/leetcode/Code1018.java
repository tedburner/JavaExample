package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2021/1/14 19:39
 * @description: 可被 5 整除的二进制前缀
 */
public class Code1018 {

    public static List<Boolean> prefixesDivBy5(int[] A) {
        int length = A.length;
        int preNum = 0;
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            // 当前数 = 上一个数 * 2 + A[i]
            preNum = ((preNum << 1) + A[i]) % 5;
            list.add(preNum == 0);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1};
        List<Boolean> list = prefixesDivBy5(A);
        list.forEach(System.out::println);
    }
}
