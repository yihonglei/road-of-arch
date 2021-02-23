package com.jpeony.algorithm.leetcode.linked;

/**
 * 链表原地反转
 *
 * @author yihonglei
 */
public class ReverseLinkedListSimple {
    /**
     * 时间复杂度：O(n)，根据加法法则，耗时最多在 while 循环了 n 次；
     * 空间复杂度：O(1)，只需要一个临时存储空间；
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode res = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = res;
            res = curr;
            curr = nextTmp;
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
