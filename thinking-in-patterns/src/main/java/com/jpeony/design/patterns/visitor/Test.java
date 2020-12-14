package com.jpeony.design.patterns.visitor;

/**
 * @author yihonglei
 */
public class Test {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        StringElement stringElement = new StringElement("strtest");

        stringElement.accept(visitor);

        FloatElement floatElement = new FloatElement(new Float(1.5));

        floatElement.accept(visitor);

    }
}