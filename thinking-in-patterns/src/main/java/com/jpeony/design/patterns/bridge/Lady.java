package com.jpeony.design.patterns.bridge;

/**
 * RefinedAbstraction: 对抽象类person进行扩展为Lady
 *
 * @author yihonglei
 */
public class Lady extends Person {
    public Lady() {
        setType("女士");
    }

    @Override
    public void dress() {
        Clothing clothing = getClothing();
        clothing.personDressCloth(this);
    }

}
