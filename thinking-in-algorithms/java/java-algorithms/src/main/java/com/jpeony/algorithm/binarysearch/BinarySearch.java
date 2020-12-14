package com.jpeony.algorithm.binarysearch;

/**
 * 简单二分查找算法
 *
 * @author yihonglei
 */
public class BinarySearch {
    public static void main(String[] args) {
        // 查找数组
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 目标元素
        int target = 4;
        // 目标元素下标位置，默认-1
        int index = -1;
        // 低位
        int low = 0;
        // 高位
        int high = arr.length - 1;

        // 查找目标元素下标
        while (low <= high) {
            // 中位
            int mid = low + (high - low) / 2;
            // 中间位置为目标元素
            if (arr[mid] == target) {
                index = mid;
                break;
            }
            // 如果中间元素大于目标元素，说明要查找的元素在数组的左边范围，缩小查找范围，高位变为mid - 1，继续查找
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                // 如果中间元素小于目标元素，说明要查找的元素在数组的右边范围，缩小查找范围，低位变为mid + 1，，继续查找
                low = mid + 1;
            }
        }

        // 结果输出
        if (index >= 0) {
            System.out.println("target-index = " + index + ", target-value = " + arr[index]);
        } else {
            System.out.println("Target element not found");
        }
    }
}
