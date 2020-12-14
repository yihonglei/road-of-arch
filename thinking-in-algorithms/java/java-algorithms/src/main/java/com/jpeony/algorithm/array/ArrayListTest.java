package com.jpeony.algorithm.array;

import java.util.ArrayList;

/**
 * @author yihonglei
 */
public class ArrayListTest {
    public static void main(String[] args) {
        // 指定容量创建数组
        ArrayList<String> arrayList = new ArrayList<>(3);
        // 添加元素
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        // 打印元素
        for (int i = 0;i < arrayList.size();i ++) {
            System.out.println(arrayList.get(i));
        }
    }
}
