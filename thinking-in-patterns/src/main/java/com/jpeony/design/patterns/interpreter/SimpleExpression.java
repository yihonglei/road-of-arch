package com.jpeony.design.patterns.interpreter;

/**
 * Expression:实现与文法中的元素相关联的解释操作
 *
 * @author yihonglei
 */
public class SimpleExpression extends Expression {

    @Override
    void interpret(Context ctx) {
        System.out.println("普通解释器");
    }

}
