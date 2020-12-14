package com.jpeony.design.patterns.memento;

/**
 * Memento: 备忘录存储原发器对象的内部状态
 *
 * @author yihonglei
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}