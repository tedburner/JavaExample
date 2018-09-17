package com.example.algorithm.Sort;

import java.util.Arrays;

/**
 * @author lingjun.jlj
 * @date 2017-12-24
 * @description: 插入排序
 **/
public class InsertSort {


    public static void main(String[] args) {
        int[] arry = {3, 2, 1, 8, 5, 10, 22, 18, 12, 77, 47};
        InsertSort(arry);
        System.out.println(Arrays.toString(arry));
    }

    public static void InsertSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int j = i;
            int target = array[i];
            while (j > 0 && target < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = target;
        }
    }
}
