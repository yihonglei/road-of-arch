package com.jpeony.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 【两数之和】https://leetcode-cn.com/problems/two-sum/
 *
 * @author yihonglei
 */
public class TwoSum {
    /**
     * 【暴力枚举】
     * 时间复杂度：根据乘法法则，嵌套代码等于内外代码的乘积，所以时间复杂度为 O(n^2)
     * 空间复杂度：每次只需要一个临时存储变量的空间，所以空间复杂度为 O(1)
     */
    private static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 【哈希表】
     * 时间复杂度：根据循环次数，关注循环代码，所以时间复杂度为 O(n)
     * 空间复杂度：每次循环的值都加入到内存中，所以空间复杂度为 O(n)
     */
    private static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            }

            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        // 暴力枚举
        int[] resOne = twoSum1(nums, target);
        System.out.println("暴力枚举：" + Arrays.toString(resOne));
        // 哈希表
        int[] resTwo = twoSum2(nums, target);
        System.out.println("哈希表：" + Arrays.toString(resTwo));
    }
}
