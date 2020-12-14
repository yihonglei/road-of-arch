package com.jpeony.design.patterns.decorator.demo3;

/**
 * 具体构件
 *
 * @author yihonglei
 */
public class Student implements Person {

    @Override
    public void study() {
        System.out.println("学生以学习为重任");
    }
}
