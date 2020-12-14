package com.jpeony.design.patterns.decorator.demo3;

/**
 * 具体装饰: 第二类学生，不抽烟
 *
 * @author yihonglei
 */
public class StudentDecoratorTwo extends Decorator {
    @Override
    public void study() {
        super.study();
        smoking();
    }

    private void smoking() {
        System.out.println("不抽烟");
    }
}
