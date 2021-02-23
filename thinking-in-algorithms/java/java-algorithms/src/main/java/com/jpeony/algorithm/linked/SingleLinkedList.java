package com.jpeony.algorithm.linked;

/**
 * 单链表的插入、删除、查找操作，链表内存int类型数据
 *
 * @author yihonglei
 */
public class SingleLinkedList {
    /**
     * 定义头节点
     */
    private Node head = null;

    /**
     * 从尾部添加节点
     */
    public void addLast(int value) {
        // 构建新节点
        Node newNode = new Node(value, null);

        // 如果头节点为空，新节点作为头节点
        if (head == null) {
            head = newNode;
        } else {
            // 查找链表最后一个节点，即节点的next引用为null的节点
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            // 添加到尾部
            q.next = newNode;
        }
    }

    /**
     * 从头部添加节点
     */
    public void addFirst(int value) {
        Node newNode = new Node(value, null);

        if (head == null) {
            head = newNode;
        } else {
            // 新节点添加到头部
            newNode.next = head;
            // 重置头节点为新节点
            head = newNode;
        }
    }

    /**
     * 根据value 获取节点
     */
    public Node getByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }

        return p;
    }

    /**
     * 根据下标 获取节点
     */
    public Node getByIndex(int index) {
        Node p = head;
        int operation = 0;
        while (p != null && operation != index) {
            ++operation;
        }

        return p;
    }

    /**
     * 根据value 删除节点
     */
    public boolean remove(int value) {
        if (head == null) {
            return false;
        }

        Node p = head;
        // 要删除节点的上一个节点
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) {
            return false;
        }

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
        return true;
    }

    /**
     * 单链表节点
     */
    private static class Node {
        /**
         * 元数据
         */
        private int data;
        /**
         * 下一个节点引用
         */
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 打印链表
     */
    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        System.out.println("==addFirst==");
        singleLinkedList.addFirst(1);
        singleLinkedList.printAll();

        System.out.println("==addLast==");
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(3);
        singleLinkedList.printAll();

        System.out.println("==getByValue:" + (1 == singleLinkedList.getByValue(1).data));

        System.out.println("==getByIndex:" + singleLinkedList.getByIndex(0).data);

        System.out.println("==remove==");
        singleLinkedList.remove(2);
        singleLinkedList.printAll();
    }

}
