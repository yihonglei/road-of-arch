package com.jpeony.algorithm.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 【无重复字符的最长子串】https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author yihonglei
 */
public class LengthOfLongestSubstring {
    // from 官网
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int endPoint = -1, maxLength = 0;
        for (int startPoint = 0; startPoint < n; ++startPoint) {
            if (startPoint != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(startPoint - 1));
            }
            while (endPoint + 1 < n && !occ.contains(s.charAt(endPoint + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(endPoint + 1));
                ++endPoint;
            }
            // 第 startPoint 到 endPoint 个字符是一个极长的无重复字符子串
            maxLength = Math.max(maxLength, endPoint - startPoint + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";

        System.out.println(lengthOfLongestSubstring(s));
    }
}
