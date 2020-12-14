package com.jpeony.design.patterns.absfactory;

/**
 * 猫类产品具体实现--黑猫
 *
 * @author yihonglei
 */
public class BlackCat implements ICat {
    @Override
    public void eat() {
        System.out.println("黑猫--吃东西");
    }
}
