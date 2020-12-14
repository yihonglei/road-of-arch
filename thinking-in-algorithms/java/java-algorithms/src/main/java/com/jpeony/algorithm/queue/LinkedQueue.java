package com.jpeony.algorithm.queue;

/**
 * 链式队列：基于链表实现队列
 *
 * @author yihonglei
 */
public class LinkedQueue {
    /**
     * 队头
     */
    private Node head = null;

    /**
     * 队尾
     */
    private Node tail = null;

    /**
     * 入队
     */
    public boolean enqueue(int data) {
        // 构建结点
        Node newNode = new Node(data, null);
        // 如果尾结点为空，队列为空，头尾结点为当前结点
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            // 队尾添加结点，尾结点为当前节点
            tail.next = newNode;
            tail = newNode;
        }
        return true;
    }

    /**
     * 出队
     */
    public int dequeue() {
        // 如果头结点为空，队列为空，返回默认-1
        if (head == null) {
            return -1;
        }
        // 从头结点取值
        int data = head.data;
        // 头结点下移到下一个结点，如果下一个结点为空，说明队列只有一个元素，出队后需要重置队列为空
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    /**
     * 单链表结点
     */
    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // 构建队列
        LinkedQueue linkedQueue = new LinkedQueue();
        // 入队
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        // 出队
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
    }
}
