package com.jpeony.design.patterns.singleton.lazysafe;

/**
 * 懒汉式(线程安全，同步方法)[不推荐用]
 * <p>
 * 通过同步代码块来保证线程的安全，只创建一个对象，但是效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
 * 而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了。方法进行同步效率太低要改进。
 *
 * @author yihonglei
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {

    }

    public synchronized static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
