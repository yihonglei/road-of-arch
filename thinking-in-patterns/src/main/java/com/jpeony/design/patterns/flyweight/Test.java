package com.jpeony.design.patterns.flyweight;

/**
 * Client: 维持一个对flyweight的引用
 *
 * @author yihonglei
 */
public class Test {
    public static void main(String[] args) {
        Flyweight fly1 = FlyweightFactory.getFlyweight("a");
        fly1.action(1);

        Flyweight fly2 = FlyweightFactory.getFlyweight("a");
        fly1.action(1);
        /*
         * 调用一个享元对象flyweight的时候，享元工厂角色（Flyweight Factory对象）
         * 会检查系统中是否已经有一个符合要求的享元对象。如果已经有了，享元工厂角色就应当提供这个已有的享元对象；
         * 如果系统中没有一个适当的享元对象的话，享元工厂角色就应当创建一个合适的享元对象。
         * eg:
         * fly1调用时没有符合要求的享元对象，享元工厂创建享元对象，
         * 第二次调用时，存在合适的享元对象，发现有现成的，所以就提供已经有的享受元对象。
         * 所以，fly1与fly2为同样的享元对象
         */
        // true
        System.out.println(fly1 == fly2);

        Flyweight fly3 = FlyweightFactory.getFlyweight("b");
        fly3.action(2);

        Flyweight fly4 = FlyweightFactory.getFlyweight("c");
        fly4.action(3);

        System.out.println(FlyweightFactory.getSize());

    }
}
