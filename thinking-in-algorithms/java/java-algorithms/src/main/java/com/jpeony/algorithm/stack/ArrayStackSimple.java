package com.jpeony.algorithm.stack;

/**
 * 极简版
 *
 * @author yihonglei
 */
public class ArrayStackSimple {
    private int[] elements;

    // 构造器
    public ArrayStackSimple(int length) {
        elements = new int[length];
    }

    // 入栈
    public void push(int element) {
        int[] newArr = new int[elements.length + 1];

        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }

        newArr[elements.length] = element;

        elements = newArr;
    }

    // 出栈
    public int pop() {
        if (elements.length == 0) {
            return -1;
        }

        int element = elements[elements.length - 1];

        int[] newArr = new int[elements.length - 1];

        for (int i = 0; i < elements.length - 1; i++) {
            newArr[i] = elements[i];
        }

        elements = newArr;

        return element;
    }

    public static void main(String[] args) {
        ArrayStackSimple stack = new ArrayStackSimple(10);

        for (int i = 0; i < 20; i++) {
            stack.push(i + 1);
        }

        System.out.println(stack.pop());
    }
}
