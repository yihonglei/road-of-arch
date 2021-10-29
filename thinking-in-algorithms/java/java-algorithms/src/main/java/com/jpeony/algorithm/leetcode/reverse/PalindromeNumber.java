package com.jpeony.algorithm.leetcode.reverse;

/**
 * 【回文数】https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author yihonglei
 */
public class PalindromeNumber {
    /**
     * 算法实现：数值正序和反转后相等，即是回文数；
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean isPalindrome(int x) {
        // 小于 0，不存在回文
        if (x < 0) {
            return false;
        }
        // 整数个位数，必然回文
        if (x < 10) {
            return true;
        }
        // 整数反转
        int y = 0;
        int tmp = x;
        while (tmp != 0) {
            y = y * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        // 反转数和原数相等则回文
        return y == x;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }
}
