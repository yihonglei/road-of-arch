package com.jpeony.algorithm.leetcode.string;

import java.util.HashMap;

/**
 * 【最长公共前缀】https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author yihonglei
 */
public class LongestCommonPrefix {
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        int size = strs.length;
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();
        // 最大字符串长度
        int lenMax = 0;
        for (String str : strs) {
            if (str.length() > lenMax) {
                lenMax = str.length();
            }
        }
        // 循环取整
        boolean flag = false;
        for (int i = 0; i < lenMax; i++) {
            if (flag) {
                break;
            }
            for (int j = 0; j < size; j++) {
                char[] chars = strs[j].toCharArray();
                if (i > chars.length - 1) {
                    flag = true;
                    break;
                }
                // 字符
                String str = String.valueOf(chars[i]);
                if (j == 0) {
                    map.put(str, str);
                    continue;
                }

                if (map.get(str) == null) {
                    flag = true;
                    break;
                }

                if (j == (size - 1)) {
                    map = new HashMap<>();
                    sb.append(str);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("longest common prefid: " + longestCommonPrefix(strs));
    }
}
