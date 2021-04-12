package com.jpeony.algorithm.leetcode.array;

import java.util.HashMap;

/**
 * 【存在重复元素】https://leetcode-cn.com/problems/contains-duplicate/
 *
 * @author yihonglei
 */
public class ContainsDuplicate {
    /**
     * 哈希表
     */
    public static boolean containsDuplicateHash(int[] nums) {
        HashMap<Integer, Integer> eachMap = new HashMap<>();
        for (int num : nums) {
            Integer tmp = eachMap.get(num);
            if (tmp != null) {
                return true;
            }
            eachMap.put(num, num);
        }

        return false;
    }

    /**
     * 字符串匹配
     */
    public static boolean containsDuplicateHashStr(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            String tmpStr = "#" + num + "#";
            if (sb.toString().contains(tmpStr)) {
                return true;
            }
            sb.append(tmpStr);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        System.out.println("哈希表:" + containsDuplicateHash(nums));
        System.out.println("字符串匹配:" + containsDuplicateHash(nums));
    }
}
