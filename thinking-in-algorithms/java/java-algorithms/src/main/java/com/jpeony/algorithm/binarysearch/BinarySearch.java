package com.jpeony.algorithm.binarysearch;

/**
 * 【二分查找或折半查找】
 * 数据二分，中值对比，范围缩减，找到为止。
 * 即每次跟中间值对比，将待查找范围缩小一半，直到找到要查找的元素，或者区间被缩小为0。
 * 【复杂度】
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 * 【实现注意】
 * 1、循环退出条件，是 low<=high，而不是 low
 * 2、mid 的取值，mid=(low+high)/2 可能会溢出，low+(high-low)/2 优化版本，low+((high-low)>>1) 最高性能
 * 3、low 和 high 的更新，一定要搞清楚待搜索空间是左区间还是右区间，别缩错了
 * 【应用场景】
 * 1、只支持顺序表结构，简单说就是数组
 * 2、二分查找针对的是有序数据
 * 3、数据量太小不适合二分查找
 * 4、数据量太大也不适合二分查找
 *
 * @author yihonglei
 */
public class BinarySearch {
    private static int search(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 4;
        int index = search(arr, arr.length, target);
        System.out.println("index = " + index);
    }
}
