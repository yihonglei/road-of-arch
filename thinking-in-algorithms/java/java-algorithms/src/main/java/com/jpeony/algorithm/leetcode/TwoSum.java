package com.jpeony.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 【题源】https://leetcode-cn.com/problems/two-sum/
 *
 * @author yihonglei
 */
public class TwoSum {
    /**
     * 暴力枚举
     */
    private static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 哈希表
     */
    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer/* 元素值 */, Integer /* 元素对应下标 */> hashTable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                return new int[]{hashTable.get(target - nums[i]), i};
            }

            hashTable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] intsOne = twoSum1(nums, target);
        System.out.println(Arrays.toString(intsOne));

        int[] intsTwo = twoSum2(nums, target);
        System.out.println(Arrays.toString(intsTwo));
    }
}
