package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/6 15:06
 * @description: 整数转罗马数字
 */
public class Code12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int number = num;
        StringBuilder result = new StringBuilder();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (number >= nums[i]) {
                result.append(romans[i]);
                number -= nums[i];
            }
        }
        return result.toString();
    }
}
