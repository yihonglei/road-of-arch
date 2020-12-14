package com.jpeony.design.patterns.memento;

/**
 * Originator: 原发器创建一个备忘录，用于记录当前时刻的内部状态
 *
 * @author yihonglei
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void setMemento(Memento memento) {
        state = memento.getState();
    }

    public void showState() {
        System.out.println(state);
    }
}