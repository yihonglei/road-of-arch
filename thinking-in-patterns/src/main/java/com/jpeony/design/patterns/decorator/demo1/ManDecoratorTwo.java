package com.jpeony.design.patterns.decorator.demo1;

/**
 * @author yihonglei
 */
public class ManDecoratorTwo extends Decorator {
    @Override
    public void eat() {
        super.eat();
        noSmoking();
        System.out.println("======第二类不抽烟男人饭后所为======");
    }

    private void noSmoking() {
        System.out.println("饭后不抽烟，没事使牙签");
    }

}
