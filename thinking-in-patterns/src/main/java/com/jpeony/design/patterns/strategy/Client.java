package com.jpeony.design.patterns.strategy;

/**
 * 客户端通过Context维护的访问方式，访问到算法的具体实现，
 * 从代码结构，我们可以看出，客户端并没直接去访问算法的具体
 * 实现，而是通过维护的Context类去访问，算法的具体实现访问
 * 控制权在于客户端
 *
 * @author yihonglei
 */
public class Client {

    public static void main(String[] args) {
        Context ctxA = new Context(new StrategyImplA());
        ctxA.doMethod();

        Context ctxB = new Context(new StrategyImplB());
        ctxB.doMethod();

    }

}
