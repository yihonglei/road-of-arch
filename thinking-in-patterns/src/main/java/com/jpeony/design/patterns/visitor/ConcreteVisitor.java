package com.jpeony.design.patterns.visitor;

/**
 * Concretevisitor: 实现每个Visitor操作声明的接口
 *
 * @author yihonglei
 */
public class ConcreteVisitor implements Visitor {

    @Override
    public void visitString(StringElement strE) {
        System.out.println(strE.getSe());
    }

    @Override
    public void visitFloat(FloatElement floatE) {
        System.out.println(floatE.getFe());
    }

}