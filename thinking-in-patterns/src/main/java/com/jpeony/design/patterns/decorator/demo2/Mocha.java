package com.jpeony.design.patterns.decorator.demo2;

/**
 * ConcreteDecorator: 装饰者，负责给被装饰者添加新行为。
 *
 * @author yihonglei
 * @date 2018/8/21 10:20
 */
public class Mocha extends CondimentDecorator {

    @Override
    public String getDescription() {
        return super.getBeverage().getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return 20 + super.getBeverage().cost();
    }
}
