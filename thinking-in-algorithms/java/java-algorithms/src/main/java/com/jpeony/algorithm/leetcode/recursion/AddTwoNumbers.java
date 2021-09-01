package com.jpeony.algorithm.leetcode.recursion;

/**
 * 【两数相加】https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author yihonglei
 */
public class AddTwoNumbers {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        // 哑结点
        ListNode dummy = new ListNode(-1);
        ListNode last = dummy;
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
            int val = sum % 10;
            // 计算进位值
            carry = sum / 10;
            // 构建节点
            curr = new ListNode(val);
            // 入队
            last.next = curr;
            last = last.next;
            // 下一节点
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 最后一次进位精度入结点
        if (carry > 0) {
            last.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * print all list node
     */
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
