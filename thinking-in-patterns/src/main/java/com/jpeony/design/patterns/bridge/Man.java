package com.jpeony.design.patterns.bridge;

/**
 * RefinedAbstraction: 对抽象类person进行扩展为Man
 *
 * @author yihonglei
 */
public class Man extends Person {

    public Man() {
        setType("男人");
    }

    @Override
    public void dress() {
        Clothing clothing = getClothing();
        clothing.personDressCloth(this);
    }

}
