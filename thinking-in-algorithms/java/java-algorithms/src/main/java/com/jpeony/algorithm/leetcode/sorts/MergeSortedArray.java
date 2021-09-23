package com.jpeony.algorithm.leetcode.sorts;

import java.util.Arrays;

/**
 * 【合并两个有序数组】https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author yihonglei
 */
public class MergeSortedArray {
    /**
     * 【直接排序】将两个数组合并，然后用插入排序进行排序
     * 时间复杂度：O(m*n^2)
     * 空间复杂度：O(m+n)
     */
    public static void mergeOne(int[] nums1, int m, int[] nums2, int n) {
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

    /**
     * 【双指针】两个有序数组，每次找出最小的值进行入队
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m+n)
     */
    public static void mergeTwo(int[] nums1, int m, int[] nums2, int n) {
        // p1 为 nums1 头指针，p2 为 nums2 头指针
        int p1 = 0, p2 = 0;
        // 排序数组
        int[] sorted = new int[m + n];
        // 合并数组
        int cur; // 当前元素
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur  = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 -1] = cur;
        }

        for (int i = 0; i < (m + n); i ++) {
            nums1[i] = sorted[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
//        mergeOne(nums1, m, nums2, n);

        mergeTwo(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}
