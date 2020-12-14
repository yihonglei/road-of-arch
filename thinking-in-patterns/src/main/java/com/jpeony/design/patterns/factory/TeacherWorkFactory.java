package com.jpeony.design.patterns.factory;

/**
 * 具体工厂(Concrete Creator)角色：
 * 这是实现抽象工厂接口的具体工厂类，包含与应用程序密切相关的逻辑，并且受到应用程序调用以创建产品对象。
 *
 * @author yihonglei
 */
public class TeacherWorkFactory implements IWorkFactory {
    @Override
    public Work getWork() {
        return new TeacherWork();
    }
}
