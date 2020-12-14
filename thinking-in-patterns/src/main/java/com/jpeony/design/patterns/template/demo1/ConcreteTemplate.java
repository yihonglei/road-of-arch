package com.jpeony.design.patterns.template.demo1;

/**
 * ConcreteClass: 继承抽象类，完成算法中与特定子类相关的步骤。
 *
 * @author yihonglei
 */
public class ConcreteTemplate extends Template {
    @Override
    public void print() {
        System.out.println("子类实现打印方法");
    }
}
