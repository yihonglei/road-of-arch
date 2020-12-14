package com.jpeony.design.patterns.bridge;

/**
 * Abstraction: 定义抽象类的接口
 *
 * @author yihonglei
 */
public abstract class Person {
    private Clothing clothing;
    private String type;

    public Clothing getClothing() {
        return clothing;
    }

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * 穿衣服的抽象方法
     */
    public abstract void dress();
}
