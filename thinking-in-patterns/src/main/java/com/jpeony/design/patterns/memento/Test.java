package com.jpeony.design.patterns.memento;

public class Test {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("某些人穷得叮当响的时候，把你当朋友");

        // 将数据封存到Caretaker中(穷的行为)
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());
        originator.showState();
        // 富裕的行为
        originator.setState("某些人富得流油的时候，便把你当陌生人");
        originator.showState();

        // 将数据重新导入(恢复为一开始穷的行为)
        originator.setMemento(caretaker.getMemento());
        originator.showState();
    }
}