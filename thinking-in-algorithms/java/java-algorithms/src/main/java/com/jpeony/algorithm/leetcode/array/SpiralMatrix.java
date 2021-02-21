package com.jpeony.algorithm.leetcode.array;

import java.util.List;

/**
 * 【螺旋矩阵】https://leetcode-cn.com/problems/spiral-matrix/
 *
 * @author yihonglei
 */
public class SpiralMatrix {
    private static List<Integer> spiralOrder(int[][] matrix) {

        return null;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        List<Integer> list = spiralOrder(matrix);

        for (Integer i : list) {
            System.out.print(i);
        }
    }
}
