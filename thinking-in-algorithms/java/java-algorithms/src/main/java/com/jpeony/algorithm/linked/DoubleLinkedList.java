package com.jpeony.algorithm.linked;

/**
 * 存入int类型双向链表，实现插入、查找、删除操作等
 *
 * @author yihonglei
 */
public class DoubleLinkedList {
    /**
     * 实际元素个数
     */
    private int size = 0;
    /**
     * 头节点
     */
    private Node first;
    /**
     * 尾节点
     */
    private Node last;

    /**
     * 尾部 添加节点
     */
    public boolean addLast(int value) {
        final Node l = last;
        final Node newNode = new Node(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * 首部 添加节点
     */
    public boolean addFirst(int value) {
        final Node f = first;
        final Node newNode = new Node(null, value, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
        return true;
    }

    /**
     * 查找节点
     */
    public int getByIndex(int index) {
        if (index < 0 || index > size) {
            return -1;
        }

        if (first == null) {
            return -1;
        }

        Node node = first;
        int operation = 0;
        while (node != null && operation != index) {
            node = node.next;
            operation++;
        }

        if (node == null) {
            return -1;
        }

        return node.item;
    }

    /**
     * 删除节点
     */
    public boolean remove(int value) {
        if (first == null) {
            return false;
        }

        Node p = first;
        // 要删除节点的上一个节点
        Node q = null;
        while (p != null && p.item != value) {
            q = p;
            p = p.next;
        }

        if (p == null) {
            return false;
        }

        if (q == null) {
            first = first.next;
        } else {
            q.next = q.next.next;
            q.next.next.prev = q;
        }

        return true;
    }

    /**
     * 打印链表
     */
    public void printAll() {
        Node p = first;
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        int item;
        Node prev;
        Node next;

        /**
         * 构造器
         */
        public Node(Node prev, int item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        System.out.println("==addFirst==");
        doubleLinkedList.addFirst(1);
        doubleLinkedList.printAll();

        System.out.println("==addLast==");
        doubleLinkedList.addLast(2);
        doubleLinkedList.printAll();

        System.out.println("==getByIndex：" + (1 == doubleLinkedList.getByIndex(0)));
        doubleLinkedList.printAll();

        System.out.println("==remove==");
        doubleLinkedList.remove(1);
        doubleLinkedList.printAll();
    }
}
