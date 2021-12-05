package com.jpeony.algorithm.leetcode.string;

import java.util.Arrays;

/**
 * 【反转字符串】https://leetcode-cn.com/problems/reverse-string/
 *
 * @author yihonglei
 */
public class ReverseString {
    /**
     * 算法思想：双指针左右数据交换，实现字符串反转。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }
        // 数组大小
        int size = s.length;
        // 左指针
        int left = 0;
        // 右指针
        int right = size - 1;
        while (left < size / 2) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("before = " + Arrays.toString(s));
        reverseString(s);
        System.out.println("after = " + Arrays.toString(s));
    }
}
