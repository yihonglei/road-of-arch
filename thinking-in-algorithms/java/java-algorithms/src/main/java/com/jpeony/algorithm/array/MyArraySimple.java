package com.jpeony.algorithm.array;

/**
 * @author yihonglei
 */
public class MyArraySimple {
    private int[] elementData;
    private int capacity = 10;
    private int size;

    public MyArraySimple() {
        this.elementData = new int[capacity];
    }

    public MyArraySimple(int capacity) {
        this.elementData = new int[capacity];
        this.capacity = capacity;
    }

    public boolean add(int e) {
        if (size > capacity) {
            return false;
        }
        // 后++
        elementData[size++] = e;
        return true;
    }

    public int get(int index) {
        if (index < 0 || index >= capacity) {
            return -1;
        }
        return elementData[index];
    }

    public boolean remove(int index) {
        if (index < 0 || index >= capacity) {
            System.out.println("下标不合法，index = " + index);
            return false;
        }

        for (int i = index + 1; i < capacity; i++) {
            elementData[i - 1] = elementData[i];
        }

        return true;
    }

    public static void main(String[] args) {
        MyArraySimple arr = new MyArraySimple();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(arr.get(1));
        System.out.println(arr.remove(0));
    }
}
