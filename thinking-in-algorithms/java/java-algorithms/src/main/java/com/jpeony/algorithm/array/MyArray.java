package com.jpeony.algorithm.array;

/**
 * 写一个存int类型的数组，实现添加、删除、根据下标随机访问等操作。
 *
 * @author yihonglei
 */
public class MyArray {
    /**
     * 声明一个int数组，默认值都是0
     */
    private int[] elements;

    /**
     * 数组容量
     */
    private int capacity;

    /**
     * 默认数组元素个数10
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 数组实际元素个数，默认0
     */
    private int size;

    /**
     * 默认构造器
     */
    public MyArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 构造器，初始化数组大小
     */
    public MyArray(int capacity) {
        elements = new int[capacity];
        this.capacity = capacity;
    }

    /**
     * 数组大小
     */
    public int size() {
        return size;
    }

    /**
     * 添加一个元素
     */
    public boolean add(int element) {
        // 数组容量判断
        if (size > capacity) {
            System.out.println("数组满了");
            return false;
        }
        // 元素添加
        elements[size++] = element;
        return true;
    }

    /**
     * 根据下标删除元素
     */
    public boolean delete(int index) {
        // 下标小于0或下标大于数组容量，则下标不合法
        if (index < 0 || index >= capacity) {
            System.out.println("下标不合法，index = " + index);
            return false;
        }
        // 从删除位置开始，将后续元素向前移动一位
        for (int i = index + 1; i < capacity; i++) {
            elements[i - 1] = elements[i];
        }

        return true;
    }

    /**
     * 获取元素
     */
    public int get(int index) {
        // 下标小于0或下标大于数组容量，返回默认值-1
        if (index < 0 || index >= capacity) {
            return -1;
        }
        return elements[index];
    }

    public static void main(String[] args) {
        // 添加元素
        System.out.println("==添加元素==");
        MyArray arrayAdd = new MyArray();
        arrayAdd.add(1);
        arrayAdd.add(2);
        for (int i = 0; i < arrayAdd.size(); i++) {
            // 获取元素
            System.out.println(arrayAdd.get(i));
        }
        // 删除元素
        System.out.println("==删除元素==");
        arrayAdd.delete(0);
        for (int i = 0; i < arrayAdd.size(); i++) {
            // 获取元素
            System.out.println("删除后元素" + arrayAdd.get(i));
        }
    }
}
