package com.jpeony.algorithm.leetcode.linked;

/**
 * 【题源】https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * @author yihonglei
 */
public class MiddleOfTheLinkedList {

    /**
     * 数组
     */
    public static ListNode middleNodeArr(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode[] arr = new ListNode[100];
        int i = 0;

        while (head != null) {
            arr[i++] = head;
            head = head.next;
        }

        return arr[i / 2];
    }

    /**
     * 单指针
     */
    public static ListNode middleNodeSinglePoint(ListNode head) {
        if (head == null) {
            return null;
        }

        int length = 0;
        ListNode curLen = head;
        while (curLen != null) {
            length++;
            curLen = curLen.next;
        }

        ListNode cur = head;
        int i = 0;
        while (i < length / 2) {
            i++;
            cur = cur.next;
        }

        return cur;
    }

    /**
     * 快慢指针
     */
    public static ListNode middleNodeFastSlow(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        ListNode tail = new ListNode(6);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = tail;


        ListNode middleNodeArr = middleNodeArr(head);
        System.out.printf("middleNodeArr: " + (middleNodeArr != null ? middleNodeArr.val : null));

        ListNode middleNodeSinglePoint = middleNodeSinglePoint(head);
        System.out.printf("middleNodeSinglePoint: " + (middleNodeSinglePoint != null ? middleNodeSinglePoint.val : null));

        ListNode middleNodeFastSlow = middleNodeFastSlow(head);
        System.out.printf("middleNodeFastSlow: " + (middleNodeFastSlow != null ? middleNodeFastSlow.val : null));
    }
}
