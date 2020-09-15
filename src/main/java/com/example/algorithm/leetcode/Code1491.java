package com.example.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/15 21:24
 * @description: 去掉最低工资和最高工资后的工资平均值
 */
public class Code1491 {

    public double average(int[] salary) {
        Arrays.sort(salary);
        int length = salary.length;
        salary[0] = 0;
        salary[length - 1] = 0;
        double sum = 0;
        for (int i = 0; i < length; i++) {
            sum += salary[i];
        }
        return sum / (length - 2);
    }

    public static void main(String[] args) {
        int[] salary = {4000, 3000, 1000, 2000};
        System.out.println(new Code1491().average(salary));
    }
}
