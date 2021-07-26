package com.jpeony.algorithm.leetcode.linked;

/**
 * 【合并两个有序链表】https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author yihonglei
 */
public class MergeTwoSortedLists {
    /**
     * 【迭代】
     * 1、定义个头结点，还有一个尾节点；
     * 2、不断在尾部添加元素；
     * 3、其中一个尾 null 时，将另外一个不为 null 的添加到队尾，因为两个链表是有序的；
     */
    private static ListNode mergeTwoListsWhile(ListNode l1, ListNode l2) {
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

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        last.next = l1 == null ? l2 : l1;

        return head.next;
    }

    /**
     * 递归
     */
    private static ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // 迭代
         ListNode listNode = mergeTwoListsWhile(l1, l2);
        
        // 递归
//        ListNode listNode = mergeTwoListsRecursion(l1, l2);
//        while (listNode != null) {
//            System.out.print(listNode.val + " ");
//            listNode = listNode.next;
//        }
    }
}
