package com.jpeony.algorithm.leetcode.array;

/**
 * 【题源】https://leetcode-cn.com/problems/single-number/
 * 只出现一次的数字
 *
 * @author yihonglei
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 2, 10, 8, 7, 8, 9, 9};

        System.out.println(singleNumber(nums));
    }
}
