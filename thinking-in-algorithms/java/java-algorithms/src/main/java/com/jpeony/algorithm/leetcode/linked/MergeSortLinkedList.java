package com.jpeony.algorithm.leetcode.linked;

/**
 * 【排序链表】https://leetcode-cn.com/problems/sort-list/
 * 【参考解法】https://leetcode-cn.com/problems/sort-list/solution/pai-xu-lian-biao-di-gui-die-dai-xiang-jie-by-cherr/
 *
 * @author yihonglei
 */
public class MergeSortLinkedList {
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
            System.out.print(head.val);
            head = head.next;
        }
    }

    /**
     * 自顶向下归并排序，时间复杂度 O(nlogn)，空间复杂度O(logn)
     */
    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        /*
         * 【通过快慢指针找到链表中点】
         * 快指针每次走两步，慢指针每次走一步。遍历完链表时，慢指针停留的位置就在链表的中点。
         */
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;

        return merge(sortList(head), sortList(rightHead));
    }

    private static ListNode merge(ListNode left, ListNode right) {
        // 哑结点，不参与链表具体业务，减少链表实现难度
        ListNode last = new ListNode(-1);
        ListNode res = last;
        while (left != null && right != null) {
            // 迭代追加往链表追加元素
            if (left.val < right.val) {
                last.next = left;
                left = left.next;
            } else {
                last.next = right;
                right = right.next;
            }
            // last 往后移动，不断追加元素
            last = last.next;
        }
        // 剩余链表合并追加
        last.next = left != null ? left : right;
        // 返回排序好的链表头
        return res.next;
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
        System.out.println("");
        ListNode sortedHead = sortList(head);
        printAll(sortedHead);
    }
}
