package com.jpeony.design.patterns.memento;

/**
 * Caretaker: 负责保存好备忘录，不能对备忘录的内部进行操作或检索
 *
 * @author yihonglei
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

}