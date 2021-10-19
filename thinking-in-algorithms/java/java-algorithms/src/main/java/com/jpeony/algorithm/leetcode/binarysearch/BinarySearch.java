package com.jpeony.algorithm.leetcode.binarysearch;

/**
 * 【二分查找】https://leetcode-cn.com/problems/binary-search/
 *
 * @author yihonglei
 */
public class BinarySearch {
    private static int search(int[] nums, int target) {
        // 低位
        int low = 0;
        // 高位
        int high = nums.length - 1;

        while (low <= high) {
            // 中位
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) { // 往左查找
                high = mid - 1;
            } else { // 往右查找
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        int targetIndex = search(nums, target);
        System.out.println("targetIndex：" + targetIndex);
    }
}
