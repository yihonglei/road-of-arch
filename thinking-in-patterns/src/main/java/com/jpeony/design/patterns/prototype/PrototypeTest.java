package com.jpeony.design.patterns.prototype;

/**
 * @author yihonglei
 */
public class PrototypeTest {
    public static void main(String[] args) {
        // 原类
        Prototype prototype1 = new ConcretePrototype("prototypeTest");
        // 克隆类
        Prototype prototype2 = (Prototype) prototype1.clone();

        System.out.println(prototype1.getName());
        System.out.println(prototype2.getName());
    }
}
