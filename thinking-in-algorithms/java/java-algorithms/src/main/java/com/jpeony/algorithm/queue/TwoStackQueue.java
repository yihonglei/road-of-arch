package com.jpeony.algorithm.queue;

import java.util.LinkedList;

/**
 * 基于两个栈实现队列，Stack 性能太慢了，因为基于 Vector 实现的。
 * 咱们基于 LinkedList 实现入栈和出栈操作，然后实现队列。
 *
 * @author yihonglei
 */
public class TwoStackQueue {
    /**
     * 负责插入操作
     */
    LinkedList<Integer> in;
    /**
     * 负责删除操作
     */
    LinkedList<Integer> out;

    public TwoStackQueue() {
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }

    /**
     * 入队
     */
    public void appendTail(int value) {
        in.push(value);
    }

    /**
     * 出队
     */
    public int deleteHead() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.poll());
            }
        }

        if (!out.isEmpty()) {
            return out.pop();
        }

        return -1;
    }
}
