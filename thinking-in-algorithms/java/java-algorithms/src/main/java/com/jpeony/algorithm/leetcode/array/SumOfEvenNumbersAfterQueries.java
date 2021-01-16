package com.jpeony.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 【题源】https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries/
 * 查询后的偶数和
 *
 * @author yihonglei
 */
public class SumOfEvenNumbersAfterQueries {
    private static int[] sumEvenAfterQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < arr.length; i++) {
            int[] twoArr = queries[i];
            int modifyIndex = twoArr[1];
            int modifyValue = twoArr[0];

            int modifyAfter = arr[modifyIndex] + modifyValue;

            arr[modifyIndex] = modifyAfter;

            int sum = 0;
            for (int tmp : arr) {
                if (Math.abs(tmp) % 2 != 0) {
                    continue;
                }
                sum = sum + tmp;
            }
            result[i] = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        System.out.println(Arrays.toString(sumEvenAfterQueries(arr, queries)));
    }
}
