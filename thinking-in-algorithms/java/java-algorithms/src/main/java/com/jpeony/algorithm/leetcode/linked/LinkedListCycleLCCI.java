package com.jpeony.algorithm.leetcode.linked;

import java.util.HashSet;
import java.util.Set;

/**
 * 【环路检测】https://leetcode-cn.com/problems/linked-list-cycle-lcci/
 * <p>
 * 【判断链表中是否存在环】https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=188&&tqId=38576&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 *
 * @author yihonglei
 */
public class LinkedListCycleLCCI {

    /**
     * 【哈希表】
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public static boolean hasCycleSet(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }

        return false;
    }

    /**
     * 【快慢指针】
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static boolean hasCycleFastSlowPoint(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);
        ListNode tail = new ListNode(4);

        head.next = one;
        one.next = two;
        two.next = tail;
        tail.next = head;

        System.out.println("hasCycleSet = " + hasCycleSet(head));
        System.out.println("hasCycleFastSlowPoint = " + hasCycleFastSlowPoint(head));
    }
}
