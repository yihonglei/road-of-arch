package com.jpeony.algorithm.array;

/**
 * 多维数组，创建方式与一维数组一样，也即数组里面套数组。
 *
 * @author yihonglei
 */
public class ManyArrayTest {
    public static void main(String[] args) {
        int[][] arrMany = {new int[2], new int[2]};
        System.out.println(arrMany[0][0]);
        // 数组里面为数组的数组，这里用二维数组举例，java中一般用到二维足够
        String[][] arrStrMany = {
                // 数组1
                new String[]{"one", "two"},
                // 数组2
                new String[]{"three", "four"},
        };
        // 第一个数组的第一个元素
        System.out.println(arrStrMany[0][0]);
        // 第一个数组的第二个元素
        System.out.println(arrStrMany[0][1]);
        // 第二个数组的第一个元素
        System.out.println(arrStrMany[1][0]);
        // 第二个数组的第二个元素
        System.out.println(arrStrMany[1][1]);
    }
}
