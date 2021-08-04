package com.jpeony.algorithm.leetcode.linked;

import java.util.HashMap;

/**
 * 【题源】https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author yihonglei
 */
public class DeleteDuplicates {

    /**
     * 哈希表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static ListNode deleteDuplicatesHash(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head != null) {
            if (!maps.containsKey(head.val)) {
                tail.next = new ListNode(head.val);
                tail = tail.next;
                maps.put(head.val, head.val);
            }
            head = head.next;
        }

        return dummy.next;
    }


    /**
     * 单次遍历，删除重复
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static ListNode deleteDuplicatesSingle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private static void printAll(ListNode head) {
        while (head != null) {
            System.out.printf("" + head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode tail = new ListNode(3);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = tail;

//        ListNode restNode = deleteDuplicatesHash(head);
        ListNode restNode = deleteDuplicatesSingle(head);

        printAll(restNode);
    }
}
