package com.jpeony.design.patterns.interpreter;

/**
 * AbstractExpression: 声明一个所有具体表达式都要实现的抽象接口（或者抽象类），
 * 接口中主要是一个interpret()方法，称为解释操作
 *
 * @author yihonglei
 */
public abstract class Expression {
    abstract void interpret(Context ctx);
}
