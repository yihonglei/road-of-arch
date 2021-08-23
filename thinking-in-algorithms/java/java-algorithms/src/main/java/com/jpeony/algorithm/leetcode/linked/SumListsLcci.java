package com.jpeony.algorithm.leetcode.linked;

/**
 * 【题源】https://leetcode-cn.com/problems/sum-lists-lcci/
 *
 * @author yihonglei
 */
public class SumListsLcci {
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode last = new ListNode(-1); // 哑结点(尾节点)
        ListNode res = last; // 返回值
        int carry = 0; // 进位

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else {
                sum = l2.val + carry;
                l2 = l2.next;
            }

            int cur = sum % 10; // 模运算当前值
            carry = sum / 10; // 除法运算进位值
            last.next = new ListNode(cur);
            last = last.next;
        }
        if (carry > 0) {
            last.next = new ListNode(carry);
        }

        return res.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static void printAll(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1Head = new ListNode(7);
        ListNode l1One = new ListNode(1);
        ListNode l1Two = new ListNode(6);
        l1Head.next = l1One;
        l1One.next = l1Two;

        ListNode l2Head = new ListNode(5);
        ListNode l2One = new ListNode(9);
        ListNode l2Two = new ListNode(2);
        l2Head.next = l2One;
        l2One.next = l2Two;

        ListNode resHead = addTwoNumbers(l1Head, l2Head);
        printAll(resHead);
    }
}
