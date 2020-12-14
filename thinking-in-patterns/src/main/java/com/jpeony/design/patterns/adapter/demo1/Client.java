package com.jpeony.design.patterns.adapter.demo1;

/**
 * @author yihonglei
 */
public class Client {
    public static void main(String[] args) {
        // 被适配器类
        Adaptee adaptee = new Adaptee();
        // 标准接口
        Adapter adapter = new ConcreteAdapter(adaptee);
        // Adaptee 与 Adapter两个无关的类协同工作
        adapter.adapteeMethod();
        adapter.adapterMethod();
    }
}
