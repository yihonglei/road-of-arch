package com.jpeony.design.patterns.absfactory;

/**
 * 狗类产品的具体实现--黑狗
 *
 * @author yihonglei
 */
public class BlackDog implements IDog {
    @Override
    public void eat() {
        System.out.println("黑狗--吃东西");
    }
}
