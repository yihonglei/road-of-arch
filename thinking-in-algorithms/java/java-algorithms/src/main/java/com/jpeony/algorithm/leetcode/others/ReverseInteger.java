package com.jpeony.algorithm.leetcode.others;

/**
 * 【整数反转】https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author yihonglei
 */
public class ReverseInteger {

    private static int reverse(int x) {
        // 正负标识
        int flag = 1;
        if (x < 0) {
            flag = -1;
        }
        // 取绝对值
        x = x * flag;

        // 反转
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }

        return (int) res != res ? 0 : (int) res * flag;
    }

    public static void main(String[] args) {
        int y = -2147;
        System.out.println(reverse(y));
    }
}
