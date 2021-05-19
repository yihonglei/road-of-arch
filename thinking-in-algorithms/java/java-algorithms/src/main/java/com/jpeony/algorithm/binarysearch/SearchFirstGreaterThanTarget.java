package com.jpeony.algorithm.binarysearch;

/**
 * 【二分查找-变体3】：查找第一个值大于等于给定值的元素
 *
 * @author yihonglei
 */
public class SearchFirstGreaterThanTarget {
    private static int search(int[] arr, int n, int val) {
        return -1;
    }

    public static void main(String[] args) {
        // 查找数组
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9};
        // 目标值
        int target = 3;
        // 目标值元素下标，默认-1
        int index = -1;
        // 低位
        int low = 0;
        // 高位
        int high = arr.length - 1;

        // 查找第一个值大于等于给定值的元素
        while (low <= high) {
            // 中位
            int mid = low + (high - low) / 2;
            // 如果中间元素大于等于目标元素，说明查找的元素在数组左边范围
            if (arr[mid] >= target) {
                // 第一位元素等于目标元素 或 目标元素的前一个元素小于目标元素，则当前位元素就是第一个大于等于目标元素的值
                if (mid == 0 || arr[mid - 1] < target) {
                    index = mid;
                    break;
                } else {
                    // 缩小查找范围，高位变为 high = mid - 1，继续查找
                    high = mid - 1;
                }
            } else if (arr[mid] < target) {
                // 缩小查找范围，低位变为 low = mid + 1，继续查找
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
