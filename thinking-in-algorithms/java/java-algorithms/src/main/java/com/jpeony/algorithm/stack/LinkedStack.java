package com.jpeony.algorithm.stack;

/**
 * 【链式栈】基于链表实现存储int类型的栈
 *
 * @author yihonglei
 */
public class LinkedStack {
    private Node top = null;

    /**
     * 入栈
     */
    public void push(int value) {
        Node newNode = new Node(value, null);
        if (top == null) {
            top = newNode;
        } else {
            // 从链表头结点插入元素
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 出栈 返回-1栈为空
     */
    public int pop() {
        if (top == null) {
            return -1;
        }
        // 从链表头结点取值
        int value = top.data;
        // 删除头结点
        top = top.next;
        return value;
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        // 入栈
        linkedStack.push(1);
        // 出栈
        System.out.println(linkedStack.pop());
    }
}
