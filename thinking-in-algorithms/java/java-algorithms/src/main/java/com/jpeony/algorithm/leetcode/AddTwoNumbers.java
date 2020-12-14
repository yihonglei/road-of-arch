package com.jpeony.algorithm.leetcode;

/**
 * 【题源】https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author yihonglei
 */
public class AddTwoNumbers {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 三种场景：
     * 1）长度一致：123 + 234
     * 2）长度一致进位：243 + 564
     * 3）长度不一致：123 + 2345
     * 4）末尾存在进位情况：123 + 238 = 3511
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 要返回的链表，定义头结点为哑结点，即有头链表
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 防止长度不一致
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = carry + x + y;
            // 进位1
            carry = (sum / 10);
            // 队尾插入元素
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            // 进行下一节点相加
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 末尾存在进位情况
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        // head不做数据业务，返回head.next是链表里队头的第一个元素，刚好是逆序的
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Debug
        addTwoNumbers(l1, l2);
    }
}
