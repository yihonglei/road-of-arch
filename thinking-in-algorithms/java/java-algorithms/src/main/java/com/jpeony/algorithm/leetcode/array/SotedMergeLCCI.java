package com.jpeony.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 【合并排序的数组】https://leetcode-cn.com/problems/sorted-merge-lcci/
 *
 * @author yihonglei
 */
public class SotedMergeLCCI {
    /**
     * 先合并数组，然后进行排序，不需要考虑两个两个数组是有序的。
     * 时间复杂度：O((m+n)log(m+n))
     * 空间复杂度：O(log(m+n))
     */
    private static void merge1(int[] A, int m, int[] B, int n) {
        // 合并
        for (int i = 0; i < n; i++) {
            A[m + i] = B[i];
        }
        // 插入排序
        int l = A.length;
        for (int i = 1; i < l; i++) {
            // 未排序空间元素
            int value = A[i];
            // 已排序空间长度，默认第一个元素为已排序区间
            int j = i - 1;
            // 将 value 在已排序区间找到合适的位置插入
            for (; j >= 0; j--) {
                // 比较 & 交换
                if (A[j] > value) {
                    A[j + 1] = A[j];
                } else {
                    break;
                }
            }

            A[j + 1] = value;
        }
    }

    /**
     * 双指针，利用两个数组有序的特性，新建一个临时数组，将两个数组分别循环，每次比较出较小数放入数组。
     * 时间复杂度：O(m + n）
     * 空间复杂度：O(m + n)
     */
    private static void merge2(int[] A, int m, int[] B, int n) {
        int pa = 0;
        int pb = 0;
        int[] sorted = new int[m + n];
        int cur = 0;
        while (pa < m || pb < n) {
            if (pa == m) {
                cur = B[pb++];
            } else if (pb == n) {
                cur = A[pa++];
            } else if (A[pa] < B[pb]) {
                cur = A[pa++];
            } else {
                cur = B[pb++];
            }

            sorted[pa + pb - 1] = cur;
        }
        // 不能这么赋值，外层方法传入的是引用，改变不了外部方法的值
        // A = sorted;
        // 需要循环将每个值塞入 A 数组中
        for (int i = 0; i < m + n; i++) {
            A[i] = sorted[i];
        }
    }

    /**
     * 逆向双指针，A 数组后半部分是空的，可以直接覆盖不影响结果，取较大者放入 A 数组的后面。
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(1)
     */
    private static void merge3(int[] A, int m, int[] B, int n) {
        int pa = m - 1, pb = n - 1;
        int tail = m + n - 1;
        int cur;
        while (pa >= 0 || pb >= 0) {
            if (pa == -1) {
                cur = B[pb--];
            } else if (pb == -1) {
                cur = A[pa--];
            } else if (A[pa] > B[pb]) {
                cur = A[pa--];
            } else {
                cur = B[pb--];
            }
            A[tail--] = cur;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{2, 5, 6};
        // 合并、排序
        //merge1(A, A.length - B.length, B, B.length);
        // 双指针
        // merge2(A, A.length - B.length, B, B.length);
        // 逆向双指针
        merge3(A, A.length - B.length, B, B.length);

        System.out.println(Arrays.toString(A));
    }
}
