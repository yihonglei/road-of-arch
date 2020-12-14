package com.jpeony.design.patterns.factory;

/**
 * 具体产品(Concrete Product)角色：实现接口对象为具体对象
 *
 * @author yihonglei
 */
public class TeacherWork implements Work {
    @Override
    public void doWork() {
        System.out.println("老师批改作业");
    }
}
