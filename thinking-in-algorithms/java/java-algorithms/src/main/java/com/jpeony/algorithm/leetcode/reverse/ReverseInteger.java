package com.jpeony.algorithm.leetcode.reverse;

/**
 * 【整数反转】https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author yihonglei
 */
public class ReverseInteger {
    /**
     * 算法实现：根据数据规律，取模求值加余
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int reverse(int x) {
        // 正负标识
        int flag = 1;
        if (x < 0) {
            flag = -1;
        }
        // 取绝对值
        x = x * flag;
        long res = 0;
        // 反转
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (int) res != res ? 0 : (int) res * flag;
    }

    public static void main(String[] args) {
        int x = -2147;
        System.out.println(reverse(x));
    }
}
