package com.jpeony.design.patterns.proxy.demo2;

/**
 * RealSubject: 被代理的实现类
 *
 * @author yihonglei
 */
public class ObjectImpl implements Object {
    @Override
    public void action() {
        System.out.println("======被代理的类ObjectImpl======");
    }
}
