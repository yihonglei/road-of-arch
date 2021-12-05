package com.jpeony.algorithm.leetcode.string;

import java.util.Arrays;

/**
 * 【有效的字母异位词】https://leetcode-cn.com/problems/valid-anagram/
 *
 * @author yihonglei
 */
public class ValidAnagram {
    /**
     * 算法思想：按字符串排序，比较两个字符串是否相同，想同则互为字母异位词，否则不是；
     * 时间复杂度：O(nlogn)，其中 n 为 s 的长度。排序的时间复杂度为 O(nlogn)，
     * 比较两个字符串是否相等时间复杂度为 O(n)，根据时间复杂度分析加法法则，
     * 代码总的时间复杂等于量级最大的那段代码的复杂度，所以时间复杂度为O(nlogn)；
     * 空间复杂度：O(n)，Java 中字符串是不可变的，因此我们需要额外的 O(n) 的空间
     * 来拷贝字符串，n 为字符串长度；
     */
    public static boolean isAnagramSort(String s, String t) {
        // 两个字符串必须一样长，否则，不可能是字母异位词
        if (s.length() != t.length()) {
            return false;
        }
        // 字符串转为数组
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        // 字符串排序
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        // 比较是否相同
        return Arrays.equals(sArr, tArr);
    }

    public static void main(String[] args) {
        System.out.println(isAnagramSort("nanna", "nnnaa"));
    }
}
