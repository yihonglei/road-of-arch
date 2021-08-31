package com.jpeony.algorithm.leetcode.queue;

/**
 * 【设计循环双端队列】https://leetcode-cn.com/problems/design-circular-deque/
 *
 * @author yihonglei
 */
public class DesignCircularDeque {
    private int capacity;
    private int[] arr;
    private int front;
    private int rear;

    public DesignCircularDeque(int k) {
        capacity = k + 1;
        arr = new int[capacity];

        // 头部指向第 1 个存放元素的位置
        // 插入时，先减，再赋值
        // 删除时，索引 +1（注意取模）
        front = 0;
        // 尾部指向下一个插入元素的位置
        // 插入时，先赋值，再加
        // 删除时，索引 -1（注意取模）
        rear = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        // front 被设计在数组的开头，所以是 +1
        front = (front + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public static void main(String[] args) {
        DesignCircularDeque circularDeque = new DesignCircularDeque(3);

        circularDeque.insertLast(1);
        circularDeque.insertLast(2);
        circularDeque.insertFront(3);
        circularDeque.insertFront(4);

        circularDeque.isFull();
        circularDeque.getRear();
        circularDeque.deleteLast();
        circularDeque.insertFront(4);
        circularDeque.getFront();
    }
}
