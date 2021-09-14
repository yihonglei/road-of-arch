package com.jpeony.algorithm.sorts;

import java.util.Arrays;

/**
 * 【冒泡排序】
 * 每次循环一个元素，找到合适的位置进行放置，重复 n 次，完成排序。
 *
 * @author yihonglei
 */
public class BubbleSort {
    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    private static void bubbleSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        // 循环轮次
        for (int i = 0; i < n; i++) {
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
