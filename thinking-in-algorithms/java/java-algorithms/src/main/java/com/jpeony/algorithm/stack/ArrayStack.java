package com.jpeony.algorithm.stack;

/**
 * 【顺序栈】基于数组实现存储int类型的栈
 *
 * @author yihonglei
 */
public class ArrayStack {
    /**
     * 定义一个数组
     */
    int[] elements;

    /**
     * 构造器，指定数组初始大小为0
     */
    public ArrayStack() {
        elements = new int[0];
    }

    /**
     * 入栈：在数组的末端（栈顶）添加一个元素
     */
    public void push(int element) {
        // 定义一个新数组，长度加1
        int[] newArr = new int[elements.length + 1];

        // 把原数组元素全部挪到新数组
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }

        // 添加元素到新数组，即扩容1后的数组
        newArr[elements.length] = element;

        // 使用新数组替换旧数组，即使旧数组指向新数组
        elements = newArr;
    }

    /**
     * 出栈：在数组的末端（栈顶）取出一个元素
     */
    public int pop() {
        // 判断栈是否为空
        if (elements.length == 0) {
            throw new RuntimeException("Stack is empty!");
        }

        // 1、取出数组的最后一个元素
        int element = elements[elements.length - 1];

        // 2、干掉数组的最后一个元素
        // 创建一个新数组，长度比elements小1
        int[] newArr = new int[elements.length - 1];

        // 把elements中除最后一个元素外的元素放入新数组中
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = elements[i];
        }

        // 新数组替代旧数组
        elements = newArr;

        // 返回栈顶元素
        return element;
    }

    /**
     * 查看栈顶元素(查看数组最后一个元素)
     */
    public int peek() {
        // 判断栈是否为空
        if (elements.length == 0) {
            throw new RuntimeException("Stack is empty!");
        }
        return elements[elements.length - 1];
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty() {
        return elements.length == 0;
    }

    public static void main(String[] args) {
        // 创建一个栈
        ArrayStack arrayStack = new ArrayStack();

        // 往栈顶添加元素
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);

        // 取出栈顶元素
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}
