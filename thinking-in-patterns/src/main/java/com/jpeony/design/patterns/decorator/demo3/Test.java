package com.jpeony.design.patterns.decorator.demo3;

/**
 * 装饰器模式测试
 *
 * @author yihonglei
 */
public class Test {
    public static void main(String[] args) {
        // 构件
        Person person = new Student();

        // 具体装饰,给构件(Student)动态添加不同功能
        StudentDecoratorOne one = new StudentDecoratorOne();
        StudentDecoratorTwo two = new StudentDecoratorTwo();

        one.setPerson(person);
        two.setPerson(person);

        // 调用学习方法
        one.study();
        two.study();
    }
}
