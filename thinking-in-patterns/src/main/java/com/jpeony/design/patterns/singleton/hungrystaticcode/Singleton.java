package com.jpeony.design.patterns.singleton.hungrystaticcode;

/**
 * 饿汉式（静态代码块）[可用]
 * <p>
 * 优点：写法简单，就是在类装载的时候通过静态代码块完成实例化。避免了线程同步问题。
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 *
 * @author yihonglei
 */
public class Singleton {
    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }
}
