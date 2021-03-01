package com.jpeony.algorithm.queue;

/**
 * 顺序队列：基于数组实现队列
 *
 * @author yihonglei
 */
public class ArrayQueue {
    /**
     * 数组定义
     */
    private int[] elements;
    /**
     * 数组大小
     */
    private int size = 0;
    /**
     * 默认数组容量
     */
    private int defaultCapacity = Integer.MAX_VALUE;
    /**
     * 队头下标，默认指在数组下标为 0 的位置
     */
    private int head = 0;
    /**
     * 队尾下标，默认指在数组下标为 0 的位置
     */
    private int tail = 0;

    public ArrayQueue() {
        elements = new int[defaultCapacity];
        size = defaultCapacity;
    }

    /**
     * 初始化数组
     */
    public ArrayQueue(int capacity) {
        elements = new int[capacity];
        size = capacity;
    }

    /**
     * 入队
     */
    public boolean enqueue(int element) {
        // 如果 tail == size，队列已满
        if (tail == size) {
            return false;
        }
        // 入队操作
        elements[tail] = element;
        // 尾部坐标后移
        ++tail;
        ++size;
        return true;
    }

    /**
     * 出队
     */
    public int dequeue() {
        // 如果 head == tail，表示队列为空
        if (head == tail) {
            return -1;
        }
        // 取出元素
        int element = elements[head];
        // 坐标往后移
        ++head;
        return element;
    }

    /**
     * 先进先出
     */
    public static void main(String[] args) {
        // 创建数组
        ArrayQueue arrayQueue = new ArrayQueue(5);
        // 入队
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        // 出队
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
    }
}
