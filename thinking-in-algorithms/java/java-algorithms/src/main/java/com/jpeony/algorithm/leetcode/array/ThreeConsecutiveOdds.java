package com.jpeony.algorithm.leetcode.array;

/**
 * 【题源】https://leetcode-cn.com/problems/three-consecutive-odds/
 * 存在连续三个奇数的数组
 *
 * @author yihonglei
 */
public class ThreeConsecutiveOdds {
    public static boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int count = 0;
        for (int value : arr) {
            if (value % 2 == 1) {
                count += 1;
            } else {
                count = 0;
            }

            if (count == 3) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 34, 3, 4, 5, 7, 23, 12};

        System.out.println(threeConsecutiveOdds(arr));
    }
}
