package com.example.algorithm.Sort;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/17 14:37
 * @description:
 */
public class SortTest {

    public static void main(String[] args) {

    }

    /**
     * 原理：比较两个相邻的元素，将值大的元素交换至右端
     * 平均时间复杂度为：O(n2)
     * 稳定
     */
    public static void BubbleSort(int[] arr) {
        int i, j;
        int n = arr.length;
        int target;
        for (i = 0; i < n - 1; i++) {

            for (j = 0; j < n - 1 - i; j++) {
                //左边比右边大
                if (arr[j] > arr[j + 1]) {
                    target = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = target;
                }
            }
        }
    }

    /**
     * 插入排序
     */
    public static void InsertSort(int[] arr) {
        int i, j;
        int n = arr.length;
        int target;

        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - (n-1)
        for (i = 1; i < n; i++) {
            j = i;
            target = arr[i];

            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = target;
        }

    }

    public static void quickSort(int a[]) {
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
