package com.jpeony.design.patterns.command;

/**
 * Receiver: 知道如何实施与执行一个请求相关的操作。任何类都可能作为一个接收者。
 *
 * @author yihonglei
 */
public class Receiver {

    public void request() {
        System.out.println("接受者类");
    }

}
