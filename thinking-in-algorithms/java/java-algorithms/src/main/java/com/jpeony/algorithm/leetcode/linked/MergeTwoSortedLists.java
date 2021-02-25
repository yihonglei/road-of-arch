package com.jpeony.algorithm.leetcode.linked;

/**
 * 【合并两个有序链表】https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author yihonglei
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoListsOne(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static ListNode mergeTwoListsTwo(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsTwo(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsTwo(l1, l2.next);
            return l2;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, null);
        l1.next = new ListNode(2, null);
        l1.next.next = new ListNode(4, null);

        ListNode l2 = new ListNode(1, null);
        l2.next = new ListNode(3, null);
        l2.next.next = new ListNode(4, null);

        ListNode listNode = mergeTwoListsOne(l1, l2);
//        ListNode listNode = mergeTwoListsTwo(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
