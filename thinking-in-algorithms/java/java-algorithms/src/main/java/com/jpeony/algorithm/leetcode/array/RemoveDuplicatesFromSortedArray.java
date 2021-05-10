package com.jpeony.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 【删除有序数组中的重复项】https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author yihonglei
 */
public class RemoveDuplicatesFromSortedArray {
    private static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length = removeDuplicates(nums);
        System.out.println("length=" + length + " nums=" + Arrays.toString(nums));
    }
}
