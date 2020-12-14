package com.jpeony.algorithm;

import java.util.Arrays;

/**
 * @author yihonglei
 */
public class TmpCode {
    private static int binarySearch(int[] arr, int n, int target) {
        if (n <= 0) {
            return -1;
        }
        // 目标元素的下标
        int index = -1;
        // 低位
        int low = 0;
        // 高位
        int high = n -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] == target) {
                index = mid;
                break;
            } else if (arr[mid] > target) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }

        if (index < 0) {
            return -1;
        }

        System.out.println("target-index = " + index + ", " + "target-value = " + arr[index]);
        return arr[index];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = binarySearch(arr, arr.length, 10);
        System.out.println(target);
    }
}
