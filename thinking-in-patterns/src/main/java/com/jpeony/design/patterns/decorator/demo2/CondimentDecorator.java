package com.jpeony.design.patterns.decorator.demo2;

/**
 * Decorator:
 * 每一个装饰者都持有一个构件(Component)对象的实例，
 * 也就是说，装饰者有一个实例变量以保存某个Component的引用，
 * 并定义一个与抽象构件接口一致的接口。
 *
 * @author yihonglei
 */
public abstract class CondimentDecorator extends Beverage {
    private Beverage beverage;

    public Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public abstract String getDescription();
}
