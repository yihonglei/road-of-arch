package com.jpeony.algorithm.leetcode.array;

import java.util.HashMap;

/**
 * 【多数元素】https://leetcode-cn.com/problems/majority-element/
 *
 * @author yihonglei
 */
public class MajorityElement {
    /**
     * 散列表方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    private static int majorityElementMap(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }

        int middle = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        for (int num : nums) {
            Integer times = map.get(num);
            if (times == null) {
                map.put(num, 1);
                continue;
            }
            ++times;
            if (times > middle) {
                return num;
            }
            map.put(num, times);
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        int majorityInt = majorityElementMap(nums);
        System.out.println("nums=" + majorityInt);
    }
}