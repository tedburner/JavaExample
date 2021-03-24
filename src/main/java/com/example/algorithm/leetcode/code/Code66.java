package com.example.algorithm.leetcode.code;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2020/1/3 10:45
 * @description: 66. 加一
 */
public class Code66 {

    public static void main(String[] args) {
        int[] digits = new int[]{9};
        System.out.println(Arrays.toString(plusOne(digits)));

    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int num = 0;
        int index = length - 1;
        int low = digits[index];
        low = low + 1;
        if (low >= 10) {
            low = low - 10;
            digits[index] = low;
            num = 1;
        } else {
            digits[index] = low;
        }

        for (int i = length - 2; i >= 0; i--) {
            int nowNum = digits[i];
            nowNum = nowNum + num;
            if (nowNum >= 10) {
                nowNum = nowNum - 10;
                digits[i] = nowNum;
                num = 1;
            } else {
                digits[i] = nowNum;
                num = 0;
            }

        }
        int[] result = new int[length + 1];
        if (num == 1) {
            result[0] = num;
            for (int i = 1; i < length + 1; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }
}
