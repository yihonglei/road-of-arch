package com.jpeony.algorithm.sorts;

import java.util.Arrays;

/**
 * 归并排序（分治思想）
 *
 * @author yihonglei
 */
public class MergeSort {
    private static int[] mergeSort(int[] sourceArray) {
        // 复制一份
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        if (arr.length < 2) {
            return arr;
        }
        // 中位数（arr.length >> 1 简单等价于 arr.length/2）
        int middle = (int) Math.floor(arr.length >> 1);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int l = 0, r = 0, len = 0;
        while (len < left.length + right.length) {
            if (left[l] <= right[r]) {
                result[len++] = left[l++];
                if (l == left.length) {
                    for (int i = r; i < right.length; i++) {
                        result[len++] = right[r++];
                    }
                }
            } else {
                result[len++] = right[r++];
                if (r == right.length) {
                    for (int i = l; i < left.length; i++) {
                        result[len++] = left[l++];
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 1, 3};
        int[] arrNew = mergeSort(arr);
        System.out.println(Arrays.toString(arrNew));
    }
}
