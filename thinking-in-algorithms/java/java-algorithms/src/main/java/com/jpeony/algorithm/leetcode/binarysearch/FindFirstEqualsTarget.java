package com.jpeony.algorithm.leetcode.binarysearch;

/**
 * 在排序数组中查找第一个等于目标元素的位置
 *
 * @author yihonglei
 */
public class FindFirstEqualsTarget {

    private static int search(int[] nums, int target) {
        // 低位
        int low = 0;
        // 高位
        int high = nums.length - 1;
        while (low <= high) {
            // 中位
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        int targetIndex = search(nums, target);
        System.out.println("targetIndex = " + targetIndex);
    }
}
