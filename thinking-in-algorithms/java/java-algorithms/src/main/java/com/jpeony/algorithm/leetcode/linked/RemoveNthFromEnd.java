package com.jpeony.algorithm.leetcode.linked;

/**
 * 【题源】https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author yihonglei
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // If head is null，direct return null.
        if (head == null) {
            return null;
        }

        // Calculate linked list size
        int length = 0;
        ListNode curLen = head;
        while (curLen != null) {
            length++;
            curLen = curLen.next;
        }

        // Calculate the index position of deleted elements in the linked list
        int removeIndex = length - n + 1;

        // remove element
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        int j = 1;
        ListNode curEle = head;
        while (curEle != null) {
            if (j != removeIndex) {
                tail.next = curEle;
                // reset tail node
                tail = tail.next;
            }

            // note!
            if (length == j) {
                tail.next = null;
            }
            curEle = curEle.next;
            j++;
        }

        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static void printAll(ListNode head) {
        while (head != null) {
            System.out.printf(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode tail = new ListNode(5);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = tail;

        System.out.printf("delete before:");
        printAll(head);

        ListNode resHead = removeNthFromEnd(head, 2);

        System.out.printf("delete after:");
        printAll(resHead);
    }
}
