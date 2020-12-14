package com.jpeony.algorithm.recursion;

/**
 * 通过递归打印1~100
 *
 * @author yihonglei
 */
public class RecursionSequence {
    private static int i = 0;

    /**
     * 递归打印1到100
     */
    private static void testRecursion01() {
        // 自增
        i++;
        // 小于等于100时回调，否则跳出回调，避免死循环
        if (i <= 100) {
            System.out.println(i);
            // 回调: 自身调用自身
            testRecursion01();
        } else {
            System.out.println("Game Over!");
        }
    }

    public static void main(String[] args) {
        // 打印1~100
        testRecursion01();
    }
}
