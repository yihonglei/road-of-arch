package com.jpeony.algorithm.sorts;

import java.util.Arrays;

/**
 * 【选择排序】
 * 跟插入排序非常类似，分为已排序区间和未排序区间，区别在于插入排序是从未排序
 * 区间取元素在已排序区间选择合适位置插入，而选择排序则是在未排序区间选择最小的元素
 * 追加到已排序区间。
 *
 * @author yihonglei
 */
public class SelectSort {
    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    private static void selectSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            // 变量声明：最小值下标
            int minPos = i;
            // 比较：查找未排序区间最小值下标
            int j = i;
            for (; j < n; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            // 交换：坐标相同，无需交换，否则，需要进行交换，将未排序区间最小值交换插入到已排序区间尾端
            if (i != minPos) {
                int tmp = arr[minPos];
                arr[minPos] = arr[i];
                arr[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 1, 3};
        selectSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
