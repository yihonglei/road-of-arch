package com.jpeony.design.patterns.visitor;

/**
 * Visitor: 为该对象结构中的ConcreteElement的每一个类声明一个visit操作。
 *
 * @author yihonglei
 */
public interface Visitor {
    public void visitString(StringElement strE);

    public void visitFloat(FloatElement floatE);
}