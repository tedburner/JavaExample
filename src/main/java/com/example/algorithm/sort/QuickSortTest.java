package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * @author lingjun.jlj
 * @date 2017-12-24
 * @description: 快排
 **/
public class QuickSortTest {

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 8, 5, 10, 22, 18, 12, 77, 47};
        QuickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void QuickSort(int a[]) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int a[], int low, int hight) {
        int i, j, target;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        target = a[i];
        while (i < j) {
            while (i < j && a[j] >= target) {
                j--;
            }
            // 用比基准小的记录替换低位记录
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] < target) {
                i++;
            }
            // 用比基准大的记录替换高位记录
            if (i < j) {
                a[j--] = a[i];
            }
        }
        // 将基准数值替换回 a[i]
        a[i] = target;
        // 对低子表进行递归排序
        sort(a, low, i - 1);
        // 对高子表进行递归排序
        sort(a, i + 1, hight);
    }


}
