package com.jpeony.design.patterns.decorator.demo3;

/**
 * 抽象装饰: 持有一个构件
 *
 * @author yihonglei
 */
public abstract class Decorator implements Person {
    protected Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public void study() {
        person.study();
    }
}
