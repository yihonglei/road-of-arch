package com.jpeony.design.patterns.absfactory;

/**
 * 猫类产品具体实现--白猫
 *
 * @author yihonglei
 */
public class WhiteCat implements ICat {
    @Override
    public void eat() {
        System.out.println("白猫--吃东西");
    }
}
