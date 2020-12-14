package com.jpeony.design.patterns.strategy;

/**
 * 新建一个Context类，负责维护具体算法实现的访问，
 * 不让客户端直接访问到算法的实现
 *
 * @author yihonglei
 */
public class Context {
    Strategy strategy;

    public Context(Strategy s) {
        this.strategy = s;
    }

    public void doMethod() {
        strategy.method();
    }
}
