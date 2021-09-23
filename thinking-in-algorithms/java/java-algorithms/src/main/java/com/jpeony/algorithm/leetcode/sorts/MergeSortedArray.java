package com.jpeony.algorithm.leetcode.sorts;

import java.util.Arrays;

/**
 * 【合并两个有序数组】https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author yihonglei
 */
public class MergeSortedArray {
    /**
     * 时间复杂度：O(m*n^2)
     * 空间复杂度：O(m+n)
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 合并
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        // 插入排序
        int len = m + n;
        for (int i = 1; i < len; i++) {
            // 未排序区间第一个元素
            int value = nums1[i];
            // 在已排序区间查找合适的位置并插入
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums1[j] > value) {
                    nums1[j + 1] = nums1[j];
                } else {
                    break;
                }
            }

            nums1[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}
