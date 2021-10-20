package com.jpeony.algorithm.leetcode.binarysearch;

import java.util.Arrays;

/**
 * 【在排序数组中查找元素的第一个和最后一个位置】https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author yihonglei
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    private static int[] searchRange(int[] nums, int target) {
        // 查找第一个等于 target 的元素下标
        int firstIndex = -1;
        // 查找最后一个等于 target 的元素下标
        int lastIndex = -1;

        // 低位
        int low = 0;
        // 高位
        int high = nums.length - 1;
        // 查找第一个等于 target 元素
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                // mid 为第一个元素或 mid 的前一个元素小于目标值，说明当前的 mid 位置元素为第一个等于 target 的元素
                if (mid == 0 || nums[mid - 1] < target) {
                    firstIndex = mid;
                    break;
                }

                // 向前移动
                high = mid - 1;
            }
        }
        // 查找最后一个等于 target 元素
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    lastIndex = mid;
                    break;
                }
                // 向后移动
                low = mid + 1;
            }
        }

        return new int[]{firstIndex, lastIndex};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] index = searchRange(nums, target);
        System.out.println("index = " + Arrays.toString(index));
    }
}
