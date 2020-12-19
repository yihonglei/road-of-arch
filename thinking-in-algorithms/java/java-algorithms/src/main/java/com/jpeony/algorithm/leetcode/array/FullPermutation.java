package com.jpeony.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 【题源】https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 *
 * @author yihonglei
 */
public class FullPermutation {

    /**
     * case1，不考虑大数溢出：
     * 1、求出最大数，循环每次加1，输出即可
     * 2、时间复杂度：最大次数的遍历，即时间复杂度为O(n)
     * 3、空间复杂度：每次占用一个临时存储空间，即空间复杂度为O(1)
     */
    public static int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n) - 1;

        int[] res = new int[max];

        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(2)));
    }
}
