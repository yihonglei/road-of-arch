package com.jpeony.algorithm.recursion;

/**
 * 递归输出 1~100
 *
 * @author yihonglei
 */
public class RecursionSequence {
    private static int i = 0;

    private static void testRecursion01() {
        i++;
        if (i <= 100) {
            System.out.println(i);
            testRecursion01();
        } else {
            System.out.println("Game Over!");
        }
    }

    public static void main(String[] args) {
        testRecursion01();
    }
}
