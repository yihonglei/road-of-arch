package com.jpeony.algorithm.leetcode.sorts;

import java.util.HashMap;

/**
 * 【将句子排序】https://leetcode-cn.com/problems/sorting-the-sentence/
 *
 * @author yihonglei
 */
public class SortingTheSentence {
    /**
     * 散列表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static String sortSentence(String s) {
        String[] sArr = s.split(" ");

        HashMap<String, String> maps = new HashMap<>();
        for (String str : sArr) {
            int len = str.length();
            String key = str.substring(len - 1);
            String value = str.substring(0, len - 1);
            maps.put(key, value);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= sArr.length; i++) {
            String keyIndex = String.valueOf(i);
            sb.append(maps.get(keyIndex));
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }
}
