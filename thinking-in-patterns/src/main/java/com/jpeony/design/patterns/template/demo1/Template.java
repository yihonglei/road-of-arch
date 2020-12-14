package com.jpeony.design.patterns.template.demo1;

/**
 * AbstractClass: 定义抽象的原语操作，具体的子类将重定义它们，将实现一个算法的各个步骤。
 *
 * @author yihonglei
 */
public abstract class Template {

    public void update() {
        System.out.println("******begin******");
        for (int i = 0; i < 10; i++) {
            print();
        }
        System.out.println("******end******");
    }

    public abstract void print();
}
