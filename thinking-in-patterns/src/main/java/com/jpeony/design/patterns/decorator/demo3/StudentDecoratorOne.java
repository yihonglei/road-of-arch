package com.jpeony.design.patterns.decorator.demo3;

/**
 * 具体装饰: 第一类学生，抽烟
 *
 * @author yihonglei
 */
public class StudentDecoratorOne extends Decorator {
    @Override
    public void study() {
        super.study();
        smoking();
        System.out.println("========================");
    }

    private void smoking() {
        System.out.println("抽烟");
    }
}
