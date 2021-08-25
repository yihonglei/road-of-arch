package com.jpeony.algorithm.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 【有效括号】https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author yihonglei
 */
public class ValidParentheses {

    private static boolean isValid(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        // 转换为字符数组
        char[] cArr = str.toCharArray();
        if (cArr.length % 2 != 0) {// 如果为奇数个元素，直接返回 false，不可能成对匹配
            return false;
        }
        // 定义字符栈
        Deque<Character> cStack = new LinkedList<>();
        // 有效括号匹配
        for (char c : cArr) {
            // 左括号入栈
            if (c == '(' || c == '{' || c == '[') {
                cStack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                // 如果为空，匹配失败
                if (cStack.isEmpty()) {
                    return false;
                }
                // 比较是否成对，如果都不符合，匹配失败
                Character cPop = cStack.pop();
                if (!((cPop == '(' && c == ')') || (cPop == '{' && c == '}') || (cPop == '[' && c == ']'))) {
                    return false;
                }
            }
        }

        return cStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }
}
