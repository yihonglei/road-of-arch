package com.jpeony.algorithm.leetcode.queue;

/**
 * 【设计循环双端队列】https://leetcode-cn.com/problems/design-circular-deque/
 *
 * @author yihonglei
 */
public class DesignCircularDeque {
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public DesignCircularDeque(int k) {

    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return -1;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return -1;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return true;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return true;
    }

    public static void main(String[] args) {
        DesignCircularDeque circularDeque = new DesignCircularDeque(3);
        circularDeque.insertLast(1);
        circularDeque.insertLast(2);
        circularDeque.insertFront(3);
        circularDeque.insertFront(4);

        circularDeque.getRear();
        circularDeque.isFull();
        circularDeque.deleteLast();
        circularDeque.insertFront(4);
        circularDeque.getFront();
    }
}
