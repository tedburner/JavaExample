package algorithm.Sort;

/**
 * @author lingjun.jlj
 * @date 2017-12-24
 * 快排
 **/
public class QuickSort {

    public static void quickSort(int a[]){
        sort(a,0,a.length-1);
    }
    public static void sort(int a[], int low, int hight) {
        int i,j,target;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        target = a[i];
        while (i<j){
            while (i < j && a[j] >= target)
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < target)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = target;// 将基准数值替换回 a[i]
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, hight); // 对高子表进行递归排序
    }
}
