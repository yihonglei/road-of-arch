package com.jpeony.algorithm.leetcode.linked;

/**
 * 【单链表反转】https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author yihonglei
 */
public class ReverseLinkedList {

    private static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        /*
         * 【方式一】
         * 创建新的链表，将原链表数据逐个放入新链表中，逻辑最清楚，但是，空间复杂度较高
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         */
        // ListNode rHead = new ListNode(head.val);
        // ListNode pNext = head.next;
        // while (pNext != null) {
        //     ListNode cur = new ListNode(pNext.val, rHead);
        //     rHead = cur;
        //     pNext = pNext.next;
        // }

        /*
         * 【方式二】
         * 原地反转，时间和空间最优
         * 时间复杂度：O(n)
         * 空间复杂度：O(1)
         */
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

    private static void printAll(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode last = new ListNode(3);
        head.next = one;
        one.next = last;

        printAll(head);
        ListNode resHead = reverseList(head);
        printAll(resHead);
    }
}
