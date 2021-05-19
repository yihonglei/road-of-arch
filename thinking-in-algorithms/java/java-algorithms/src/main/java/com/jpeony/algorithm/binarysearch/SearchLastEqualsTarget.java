package com.jpeony.algorithm.binarysearch;

/**
 * 【二分查找-变体2】：查找最后一个值等于给定值的元素
 *
 * @author yihonglei
 */
public class SearchLastEqualsTarget {
    private static int search(int[] arr, int n, int val) {
        return -1;
    }

    public static void main(String[] args) {
        // 查找数组
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9};
        // 目标元素
        int target = 3;
        // 目标元素的下标位置，默认-1
        int index = -1;
        // 低位
        int low = 0;
        // 高位
        int high = arr.length - 1;

        // 查找最后一个值等于给定值的元素
        while (low <= high) {
            // 中位
            int mid = low + (high - low) / 2;
            // 如果中间元素大于目标元素，说明查找的元素在数组左边范围，缩小查找范围，高位变为 high = mid - 1，继续查找
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                // 如果中间元素小于目标元素，说明查找的元素在数组右边范围，缩小查找范围，地位变为 low = mid + 1，继续查找
                low = mid + 1;
            } else if (arr[mid] == target){// 查找到目标元素，需要继续往前查找最后一个等于目标元素的元素
                // 最后一位元素等于目标元素 或 目标元素的后一个元素已经不是目标值，则当前位元素就是最后一个等于目标元素的值
                if (mid == arr.length - 1 || arr[mid + 1] != target) {
                    index = mid;
                    break;
                } else {
                    // 继续进行二分查找最后一个等于目标值的元素，继续查找
                    low = mid + 1;
                }
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
