package com.jpeony.algorithm.sorts;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author yihonglei
 */
public class InsertSort {
    public static void insertSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {
            // 未排序区间的第一个元素
            int value = arr[i];
            // 默认已排序区间为第一个元素
            int j = i - 1;
            // 将未排序区间的第一个元素在已排序区间找到合适的位置插入
            for (; j >= 0; --j) {
                // 比较&移动
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            // 插入（加1，弥补--j减掉的1，还原元素的真实位置）
            arr[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 1, 3};
        insertSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

}
