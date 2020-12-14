package com.jpeony.design.patterns.flyweight;

/**
 * ConcreteFlyweight: 实现Flyweight接口 ，并为内部状态（ 如果有的话 )增加存储空间 。
 *
 * @author yihonglei
 */
public class FlyweightImpl implements Flyweight {

    @Override
    public void action(int args) {
        System.out.println("参数值:" + args);
    }

}
