package com.jpeony.design.patterns.singleton.doublecheck;

/**
 * 懒汉式(双重检查)[推荐用]
 * <p>
 * Double-Check概念对于多线程开发者来说不会陌生，如代码中所示，我们进行了两次if (singleton == null)检查，这样就可以保证线程安全了。
 * 这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，直接return实例化对象。
 * 优点：线程安全；延迟加载；效率较高。
 * <p>
 * 为什么使用volatile？
 * 这是一种懒汉的单例模式，使用时才创建对象，而且为了避免初始化操作的指令重排序，给instance加上了volatile。
 * 为什么用了synchronized还要用volatile？具体来说就是synchronized虽然保证了原子性，但却没有保证指令重排序的正确性，
 * 会出现A线程执行初始化，但可能因为构造函数里面的操作太多了，所以A线程的instance实例还没有造出来，
 * 但已经被赋值了（即代码中2操作，先分配内存空间后构建对象）。
 * 而B线程这时过来了（代码1操作，发现instance不为null），错以为instance已经被实例化出来，一用才发现instance尚未被初始化。
 * 要知道我们的线程虽然可以保证原子性，但程序可能是在多核CPU上执行。
 *
 * @author yihonglei
 */
public class Singleton {
    private volatile static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
