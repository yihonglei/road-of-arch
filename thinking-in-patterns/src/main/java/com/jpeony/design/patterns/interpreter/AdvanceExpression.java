package com.jpeony.design.patterns.interpreter;

/**
 * Expression:实现与文法中的元素相关联的解释操作
 *
 * @author yihonglei
 */
public class AdvanceExpression extends Expression {

    @Override
    void interpret(Context ctx) {
        System.out.println("高级解析器");
    }

}
