package com.jpeony.algorithm.leetcode.recursion;

/**
 * 【两数相加】https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author yihonglei
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return null;
        }
        if (l2 == null) {
            return null;
        }

        // 队列头结点和尾节点
        ListNode head = null, tail = null;
        // 当前求和构建节点
        ListNode curr = null;
        // 俩数相加进位值
        int carry = 0;
        // 全部为空时退出循环
        while (l1 != null || l2 != null) {
            // 求和，为空节点补 0，为了统计求和公式
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;

            // 构建节点
            curr = new ListNode(sum % 10);
            // 计算进位值
            carry = sum / 10;

            // 入队
            if (head == null) {
                head = tail = curr;
            } else {
                tail.next = curr;
                tail = curr;
            }

            // 下一节点
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {

        }
    }

    public static void printAll(ListNode head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode sum = addTwoNumbers(l1, l2);
        printAll(sum);
    }
}
