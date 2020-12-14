package com.jpeony.algorithm.recursion;

/**
 * 通过递归计算某个数的阶乘
 *
 * @author yihonglei
 */
public class RecursionFactorial {
    /**
     * 递归计算某个数的阶乘
     */
    public static int testFactorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * testFactorial(n - 1);
        }
    }

    public static void main(String[] args) {
        // 计算5的阶乘
        System.out.println(testFactorial(5));
    }
}
