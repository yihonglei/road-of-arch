package com.jpeony.algorithm.leetcode.others;

/**
 * 【回文数】https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author yihonglei
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        if (x % 10 == 0) {
            return false;
        }

        int y = 0;
        int tmp = x;
        while (tmp > 0) {
            y = y * 10 + tmp % 10;
            tmp = tmp / 10;
        }

        return y == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
