package com.jpeony.algorithm.binarysearch;

/**
 * 二分查找
 *
 * @author yihonglei
 */
public class BinarySearch {
    private static int search(int[] arr, int n, int val) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (val == arr[mid]) {
                return mid;
            } else if (val < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = search(arr, arr.length, 4);
        System.out.println("index = " + index);
    }
}
