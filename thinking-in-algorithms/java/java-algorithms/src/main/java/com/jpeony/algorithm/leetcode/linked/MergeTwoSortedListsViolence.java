package com.jpeony.algorithm.leetcode.linked;

/**
 * 递归方式实现有序链表合并
 *
 * @author yihonglei
 */
public class MergeTwoSortedListsViolence {

    /**
     * 1、定义个头结点，还有一个尾节点；
     * 2、不断在尾部添加元素；
     * 3、其中一个尾 null 时，将另外一个不为 null 的添加到队尾，因为两个链表是有序的；
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        // 有头链表（链表的哨兵节点，不参与业务处理的结点）
        ListNode head = new ListNode();
        ListNode last = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                last.next = l1;
                l1 = l1.next;
            } else {
                last.next = l2;
                l2 = l2.next;
            }

            last = last.next;
        }

        last.next = l1 == null ? l2 : l1;

        return head.next;
    }

    /**
     * Definition for singly-linked list.
     */
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
