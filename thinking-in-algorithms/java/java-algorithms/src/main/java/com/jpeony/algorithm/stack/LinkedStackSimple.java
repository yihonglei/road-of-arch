package com.jpeony.algorithm.stack;

/**
 * 极简版
 *
 * @author yihonglei
 */
public class LinkedStackSimple {
    private Node top;

    // 入栈
    public void push(int data) {
        Node newNode = new Node(data, null);

        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    // 出栈
    public int pop() {
        if (top == null) {
            return -1;
        }

        int data = top.data;

        top = top.next;

        return data;
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
        LinkedStackSimple stack = new LinkedStackSimple();

        for (int i = 0; i < 10; i++) {
            stack.push(i + 1);
        }

        System.out.println(stack.pop());
    }
}
