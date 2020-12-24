package com.jpeony.algorithm.sorts;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author yihonglei
 */
public class SelectSort {
    public static void selectSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        // 总共要经过 N-1 轮比较
//        for (int i = 0; i < n - 1; i++) {
//            int minIndex = i;
//            // 每轮需要比较的次数 N-i，已经比较出结果的，无需再比较
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[minIndex]) {
//                    // 记录目前能找到的最小值元素的下标
//                    minIndex = j;
//                }
//            }
//
//            // 将找到的最小值和i位置所在的值进行交换
//            if (i != minIndex) {
//                int tmp = arr[i];
//                arr[i] = arr[minIndex];
//                arr[minIndex] = tmp;
//            }
//        }

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // 比较：取未排序区间最小值
            int j = i;
            for (; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            // 交换：坐标相同，无需交换，否则，需要进行交换，将未排序区间最小值交换插入到已排序区间尾端
            if (i != minIndex) {
                int tmp = arr[minIndex];
                arr[minIndex] = arr[i];
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
