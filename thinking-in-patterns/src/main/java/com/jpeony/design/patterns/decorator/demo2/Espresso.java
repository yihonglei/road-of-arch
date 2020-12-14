package com.jpeony.design.patterns.decorator.demo2;

/**
 * ConcreteComponent: 实现组件接口，用于接受动态添加行为的对象。
 *
 * @author yihonglei
 */
public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
