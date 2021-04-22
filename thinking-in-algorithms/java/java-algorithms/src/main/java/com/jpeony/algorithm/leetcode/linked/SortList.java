package com.jpeony.algorithm.leetcode.linked;

/**
 * @author yihonglei
 */
public class SortList {
    public static class ListNode {
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

    public static void printAll(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    public static ListNode insertSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 已排序区间，默认第一个元素为已排序区间
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 未排序区间
        ListNode preNode = dummy;
        // 比较&插入，从未排序区间依次选择元素在未排序区间选择合适的位置插入，不移动节点，只移动节点里面的元素
        while (head != null) {
            ListNode curNode = head;
            head = head.next;

            if (preNode.val <= curNode.val) {
                preNode = curNode;
                continue;
            }

            preNode.next = curNode.next;
            ListNode p;
            for (p = dummy; p != head; p = p.next) {
                if (p.next.val < curNode.val) {
                    continue;
                }
                curNode.next = p.next;
                p.next = curNode;
                break;
            }
        }

        head = dummy.next;
        return head;
    }

    public static ListNode mergeSortList(ListNode head) {

        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode tail = new ListNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = tail;

        printAll(head);
        ListNode sortedHead = insertSortList(head);
        printAll(sortedHead);
    }
}
