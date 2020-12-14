package com.jpeony.algorithm.array;

/**
 * 删除数组某个元素。
 *
 * @author yihonglei
 */
public class DelArrayTest {
    public static void main(String[] args) {
        // 定义一个数组
        int[] arr = {100, 200, 300, 400};
        // 遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println("删除前的数组--arr[" + i + "]：" + arr[i]);
        }
        // 要删除元素的下标
        int dst = 1;
        // 定义一个新数组，数组长度为原数组长度-1
        int[] newArr = new int[arr.length - 1];
        // 删除元素
        for (int i = 0; i < newArr.length; i++) {
            if (i < dst) {
                newArr[i] = arr[i];
            } else if (i > dst) {
                newArr[i] = arr[i + 1];
            }
        }
        // 新数组替换旧数组
        arr = newArr;
        // 遍历新数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println("删除后的数组arr[" + i + "]：" + newArr[i]);
        }
    }
}
