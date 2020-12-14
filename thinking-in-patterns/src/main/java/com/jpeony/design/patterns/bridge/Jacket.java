package com.jpeony.design.patterns.bridge;

/**
 * @author yihonglei
 */
public class Jacket extends Clothing {

    @Override
    public void personDressCloth(Person person) {
        System.out.println(person.getType() + "穿马褂");
    }

}
