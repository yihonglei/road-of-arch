package com.jpeony.design.patterns.singleton.lazyunsafe;

/**
 * 懒汉式(线程不安全)[不可用]
 * <p>
 * 这种写法起到了Lazy Loading的效果，但是只能在单线程下使用。如果在多线程下，会创建多个实例对象。
 * 比如有线程A和线程B同时访问getInstance()方法，线程A读取instance值为null，此时cpu被线程B抢去了，线程B判断instance值也为null，
 * 线程B会对instance进行实例化。线程B执行完，线程A获得cpu，由于线程A之前已经判断instance值为null，
 * 它也会去对instance进行实例化。这个时候就会产生多个实例对象。
 *
 * @author yihonglei
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
