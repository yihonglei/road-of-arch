package com.jpeony.algorithm.queue;

/**
 * @author yihonglei
 */
public class LinkedQueueSimple {
    private Node head;
    private Node tail;

    public boolean enqueue(int data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.next = newNode;
            tail = newNode;
        }

        return true;
    }

    public int dequeue() {
        if (head == null) {
            return -1;
        }

        int data = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        return data;
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedQueueSimple simple = new LinkedQueueSimple();

        simple.enqueue(1);
        simple.enqueue(2);

        System.out.println(simple.dequeue());
        System.out.println(simple.dequeue());
    }
}
