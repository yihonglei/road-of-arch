package com.jpeony.design.patterns.mediator;

/**
 * @author yihonglei
 */
public class Test {
    public static void main(String[] args) {
        Mediator md = new ConcreteMediator();

        // A特工请示
        md.notice("A特工");
        // B特工请示
        md.notice("B特工");
    }
}