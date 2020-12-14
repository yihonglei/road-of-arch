package com.jpeony.design.patterns.factory;

/**
 * 工厂方法模式应用程序测试，通过工厂创建具体产品对象。
 *
 * @author yihonglei
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        StudentWorkFactory studentWorkFactory = new StudentWorkFactory();
        studentWorkFactory.getWork().doWork();

        TeacherWorkFactory teacherWorkFactory = new TeacherWorkFactory();
        teacherWorkFactory.getWork().doWork();
    }
}
