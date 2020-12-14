package com.jpeony.design.patterns.proxy.demo2;

/**
 * @author yihonglei
 */
public class Test {
    public static void main(String[] args) {
        // 通过代理对象访问真实对象
        ProjectProxy pr = new ProjectProxy();
        pr.action();
    }
}
