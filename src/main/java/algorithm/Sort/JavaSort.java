package algorithm.Sort;

import java.util.Arrays;

/**
 * @author lingjun.jlj
 * @create 2017-09-06
 **/
public class JavaSort {

    public static void main(String[] args){
        int [] arry = {1,3,3,2,8,5,10,22,18,12,77,47};
        InsertSort.InsertSort(arry);
        System.out.println(Arrays.toString(arry));
        int a[] = { 49, 38, 65, 97, 76, 13, 27, 49 };
        QuickSort.quickSort(a);
        System.out.println(Arrays.toString(a));
        int b[] = { 19, 88, 65, 97, 76, 13, 27, 49 };
        BubbleSort.BubbleSort(b);
        System.out.println(Arrays.toString(b));
    }

}
