package com.jpeony.algorithm.leetcode.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 【用两个栈实现队列】https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * @author yihonglei
 */
public class TwoStackQueue {
    Deque<Integer> in = null;
    Deque<Integer> out = null;

    public TwoStackQueue() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }


    public int deleteHead() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        if (!out.isEmpty()) {
            return out.pop();
        }

        return -1;
    }

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();

        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);

        System.out.println(queue.deleteHead());
    }
}
