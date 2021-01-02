package com.jpeony.algorithm.leetcode.others;

/**
 * @author yihonglei
 */
public class Tmp {
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void printAll(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        // 创建一个 4、5、1、9 链表
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);

        System.out.println("1、打印原始链表");
        printAll(node);

        System.out.println("\n2、指定元素删除");
//        deleteNode(new ListNode(5)); // 删除 5 这个元素，咋调用 deleteNode() 方法 ??????

        System.out.println("\n3、删除后的链表");
        printAll(node);
    }
}
