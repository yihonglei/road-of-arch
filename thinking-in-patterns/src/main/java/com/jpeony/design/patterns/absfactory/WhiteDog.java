package com.jpeony.design.patterns.absfactory;

/**
 * 狗类产品的具体实现--白狗
 *
 * @author yihonglei
 */
public class WhiteDog implements IDog {
    @Override
    public void eat() {
        System.out.println("白狗--吃东西");
    }
}
