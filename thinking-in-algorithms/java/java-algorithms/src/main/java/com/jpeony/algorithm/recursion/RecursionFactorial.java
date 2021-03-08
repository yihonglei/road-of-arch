package com.jpeony.algorithm.recursion;

/**
 * 递归计算阶乘
 *
 * @author yihonglei
 */
public class RecursionFactorial {

    private static int testFactorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * testFactorial(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(testFactorial(5));
    }
}
