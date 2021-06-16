package com.jpeony.algorithm.binarysearch;

/**
 * 【二分查找-变体1】：查找第一个值等于给定值的元素
 *
 * @author yihonglei
 */
public class SearchFirstEqualsTarget {
    private static int search(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < arr[mid]) {
                high = mid - 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else if (arr[mid] == target) {
                if (mid == 0 || arr[mid - 1] != target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9};
        int target = 3;
        int index = search(arr, arr.length, target);
        System.out.println("index = " + index);
    }
}
