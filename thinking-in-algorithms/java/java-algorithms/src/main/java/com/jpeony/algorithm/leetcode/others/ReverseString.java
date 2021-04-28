package com.jpeony.algorithm.leetcode.others;

import java.util.Arrays;

/**
 * 【反转字符串】https://leetcode-cn.com/problems/reverse-string/
 * 通过左右指针找到首尾元素进行交换，直到交换完成。
 *
 * @author yihonglei
 */
public class ReverseString {

    /**
     * 时间复杂度O(n)，空间复杂度(1)
     */
    private static void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }
        // 左指针
        int left = 0;
        // 右指针
        int right = s.length - 1;

        for (int i = 0; i < s.length / 2; i++) {
            // 首位对应元素交换
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

        System.out.println(Arrays.toString(s));
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
