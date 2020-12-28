package com.jpeony.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 【题源】https://leetcode-cn.com/problems/reverse-string/
 *
 * @author yihonglei
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        // 如果为空或者为1，直接返回
        if (s.length <= 1) {
            return;
        }
        // 左右指针初始值
        int left = 0;
        int right = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            // 空间复杂度O(1)
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            // 左指针右移
            left++;
            // 右指针左移
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
