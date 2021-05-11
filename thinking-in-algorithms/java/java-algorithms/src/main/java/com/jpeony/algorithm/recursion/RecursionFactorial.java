package com.jpeony.algorithm.recursion;

/**
 * 【递归计算阶】
 * 【递归需要满足三个条件】
 * 1、一个问题的解可以分解为几个子问题的解；
 * 2、这个问题与分解之后的子问题，除了数据规模不同，求解思路完全一样；
 * 3、存在递归终止条件；
 * 【递归存在的问题】
 * 1、堆栈溢出，需要限制递归的深度；
 * 2、环路递归，可以限制递归深度或者环路检测处理；
 * 3、重复计算；
 * 4、函数调用耗时多；
 * 5、空间复杂度高；
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
