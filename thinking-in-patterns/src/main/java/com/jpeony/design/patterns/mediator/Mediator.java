package com.jpeony.design.patterns.mediator;

/**
 * Mediator: 中介者定义一个接口用于与各个同事(Colleaguesclass)之间进行通讯
 *
 * @author yihonglei
 */
public abstract class Mediator {
    abstract void notice(String context);
}
