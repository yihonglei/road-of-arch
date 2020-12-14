package com.jpeony.design.patterns.decorator.demo1;

/**
 *  
 *  Decorator: 持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口 
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
    public void eat() {
        person.eat();
    }
}
