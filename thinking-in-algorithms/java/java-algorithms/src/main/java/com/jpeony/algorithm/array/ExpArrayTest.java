package com.jpeony.algorithm.array;

import java.util.Arrays;

/**
 * 数组添加元素和扩容。
 *
 * @author yihonglei
 */
public class ExpArrayTest {
    public static void main(String[] args) {
        // 创建固定大小数组
        int[] arr = new int[3];
        // 赋值
        arr[0] = 100;
        arr[1] = 99;
        arr[2] = 98;
        // 添加元素前数组
        System.out.println("添加元素前数组：" + Arrays.toString(arr));
        // 将要添加的元素
        int element = 97;
        // 数组扩容：新定义一个数组，并把原扩大两倍
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        // 将原数组指向新数组
        arr = newArr;
        // 扩容后的数组
        System.out.println("扩容后数组：" + Arrays.toString(arr));
        // 添加元素
        arr[3] = element;
        // 添加元素后数组
        System.out.println("添加元素后数组：" + Arrays.toString(arr));
    }
}
