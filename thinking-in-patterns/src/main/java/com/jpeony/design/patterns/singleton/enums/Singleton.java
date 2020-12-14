package com.jpeony.design.patterns.singleton.enums;

/**
 * 枚举[推荐用]
 * <p>
 * 优点：
 * 系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使用单例模式可以提高系统性能。
 * 缺点：
 * 当想实例化一个单例类的时候，必须要记住使用相应的获取对象的方法，而不是使用new，可能会给其他开发人员造成困扰，特别是看不到源码的时候。
 *
 * @author yihonglei
 */
public class Singleton {

    private Singleton() {

    }

    /**
     * 枚举本身是单例的，主要利用枚举单例的特性创建单例对象。
     */
    private enum SingletonEnum {
        SINGLETON_ENUM;

        private Singleton singleton;

        SingletonEnum() {
            singleton = new Singleton();
        }

        public Singleton getInstance() {
            return singleton;
        }
    }

    public static Singleton getInstance() {
        return SingletonEnum.SINGLETON_ENUM.getInstance();
    }

}
