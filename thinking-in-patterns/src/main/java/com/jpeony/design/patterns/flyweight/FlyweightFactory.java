package com.jpeony.design.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * FlyweightFactory: 创建并管理flyweight对象, 确保合理地共享flyweight
 *
 * @author yihonglei
 */
public class FlyweightFactory {
    private static Map flyweights = new HashMap();

    public FlyweightFactory(String args) {
        flyweights.put(args, new FlyweightImpl());
    }

    public static Flyweight getFlyweight(String key) {
        if (flyweights.get(key) == null) {
            flyweights.put(key, new FlyweightImpl());
        }

        return (Flyweight) flyweights.get(key);
    }

    public static int getSize() {
        return flyweights.size();
    }
}
