package com.jpeony.design.patterns.decorator.demo1;

/**
 * @author yihonglei
 */
public class ManDecoratorOne extends Decorator {
    @Override
    public void eat() {
        super.eat();
        smoking();
        System.out.println("======第一类抽烟男人饭后所为======");
    }

    private void smoking() {
        System.out.println("饭后一支烟，赛过活神仙");
    }
}
