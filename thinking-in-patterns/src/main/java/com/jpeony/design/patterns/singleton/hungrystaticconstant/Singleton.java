package com.jpeony.design.patterns.singleton.hungrystaticconstant;

/**
 * 饿汉式（静态常量）[可用]
 * <p>
 * 优点：写法简单，在类装载的时候就完成实例化，避免了线程同步问题。
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 *
 * @author yihonglei
 */
public class Singleton {
    private final static Singleton INSTANCE = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
