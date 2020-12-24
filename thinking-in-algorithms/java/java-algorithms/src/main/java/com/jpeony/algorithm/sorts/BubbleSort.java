package com.jpeony.algorithm.sorts;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author yihonglei
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        // 循环轮次
        for (int i = 0; i < n - 1; i++) {
            // 每一轮比较出一个最大值固定，已经冒到上层的元素，无需再比较，优化比较性能
            for (int j = 0; j < n - 1 - i; j++) {
                // 比较&交换
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 1, 3};
        bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
