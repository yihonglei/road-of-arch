package com.jpeony.algorithm.leetcode.array;

/**
 * 【题源】https://leetcode-cn.com/problems/xor-operation-in-an-array/
 *
 * @author yihonglei
 */
public class XorOperationInAnArray {
    /**
     * 时间复杂度：O(n)。这里只关注循环次数最多的一段代码，操作了n次。
     * 空间复杂度：O(1)。这里只是用了常量级别的辅助空间。
     */
    private static int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= (start + 2 * i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
    }
}
