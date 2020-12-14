package com.jpeony.algorithm.queue;

/**
 * @author yihonglei
 */
public class ArrayQueueSimple {
    private int[] elements;
    private int capacity;
    private int head = 0;
    private int tail = 0;

    public ArrayQueueSimple(int capacity) {
        this.elements = new int[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue(int element) {
        // 队列满了
        if (tail == capacity) {
            return false;
        }
        // 队尾入队
        elements[tail] = element;
        // 尾部指针后移
        ++tail;

        return true;
    }

    public int dequeue() {
        if (head == tail) {
            return -1;
        }

        int element = elements[head];

        ++head;

        return element;
    }

    public static void main(String[] args) {
        ArrayQueueSimple simple = new ArrayQueueSimple(10);

        simple.enqueue(1);
        simple.enqueue(2);

        System.out.println(simple.dequeue());
        System.out.println(simple.dequeue());
        System.out.println(simple.dequeue());
    }

}
