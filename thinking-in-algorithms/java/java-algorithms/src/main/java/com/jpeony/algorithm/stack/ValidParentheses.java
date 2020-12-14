package com.jpeony.algorithm.stack;

import java.util.Stack;

/**
 * 【题源】https://leetcode-cn.com/problems/valid-parentheses/
 * <p>
 * 栈的括号匹配应用。
 *
 * @author yihonglei
 */
public class ValidParentheses {
    /**
     * 边界情况：
     * 1、奇数个数
     * 2、先右括号
     * 3、栈为空
     */
    public static boolean isValid(String s) {
        // 奇数个数不可能都成对出现
        if (s.length() % 2 == 1) {
            return false;
        }

        // 符号栈
        Stack<Character> cStack = new Stack<>();
        // 左符号容器
        String leftContainer = "({[";
        // 字符数组
        char[] cArr = s.toCharArray();
        // 循环比较
        for (char c : cArr) {
            // 左括号入栈
            if (leftContainer.contains(String.valueOf(c))) {
                cStack.push(c);
            } else {// 右括号比较
                // 栈为空，说明是先是右括号，无法配对
                if (cStack.isEmpty()) {
                    return false;
                }
                // 栈顶元素，左括号
                char peek = cStack.peek();
                // 配对成功，出栈
                if ((peek == '(' && c == ')') || (peek == '{' && c == '}') || (peek == '[' && c == ']')) {
                    cStack.pop();
                } else {// 配对失败
                    return false;
                }
            }
        }

        return cStack.isEmpty();
    }

    public static void main(String[] args) {
        String isValid = "()";
        System.out.println("isValid=" + isValid(isValid));
    }
}
