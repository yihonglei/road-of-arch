package com.jpeony.algorithm.array;

/**
 * 一维数组的创建和使用。
 *
 * @author yihonglei
 */
public class ArrayTest {
    public static void main(String[] args) {
        /*
         * 【方式一】
         * 通过new关键字不初始化创建数组。
         * 通过这种方式创建的数组局限性很大，创建完后数组根据类型有默认值，int默认每个元素为0，boolean默认每个元素为false。
         *
         * 【语法格式】
         * int[] arr = new int[10]
         */
        System.out.println("【方式一】");
        // 创建固定长度数组
        int[] arrInt = new int[10];
        System.out.println("通过new关键字指定长度不初始化创建数组：" + arrInt[0]);
        System.out.println("数组长度length的用法，注意跟字符串的length()差个括号：" + arrInt.length);
        // 数组赋值
        arrInt[0] = 100;
        arrInt[1] = 99;
        // 遍历数组
        for (int i = 0; i < arrInt.length; i++) {
            System.out.println("arrInt[" + i + "]：" + arrInt[i]);
        }

        /*
         * 【方式二】
         * 知道数组元素，通过new关键字初始化创建数组。
         * 注意，String[] arrString = new String[]{字符串1,字符串2,......};
         * 中括号内不能写长度，否则报错，因为已经初始化了的数组成了定局，包括长度等，
         * 如果还去指定长度，就是多此一举，直接报错。
         */
        System.out.println("【方式二】");
        // 创建数组并初始化值
        String[] arrString = new String[]{"one", "two", "three"};
        // 数组遍历
        for (int i = 0; i < arrString.length; i++) {
            System.out.println("arrString[" + i + "]：" + arrString[i]);
        }

        /*
         * 【方式三】
         * 初始化创建数组，不通过new关键字，可以看成是第二种创建方式的简写版本，
         * 这个地方的花括号就相当于方法2的new关键字，自动根据String[]创建string元素的数组。
         */
        System.out.println("【方式3】");
        String[] arrString2 = {"one", "two", "three"};
        // 数组遍历
        for (int i = 0; i < arrString2.length; i++) {
            System.out.println("arrString2[" + i + "]：" + arrString[i]);
        }
    }
}
