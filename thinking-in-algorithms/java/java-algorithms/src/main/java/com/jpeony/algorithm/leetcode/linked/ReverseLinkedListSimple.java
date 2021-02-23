package com.jpeony.algorithm.leetcode.linked;

/**
 * 链表原地反转
 *
 * @author yihonglei
 */
public class ReverseLinkedListSimple {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode res = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nextTmp = cur.next;
            cur.next = res;
            res = cur;
            cur = nextTmp;
        }

        return res;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void printAll(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        printAll(head);
        System.out.println();
        ListNode newHead = reverseList(head);
        printAll(newHead);
    }
}
