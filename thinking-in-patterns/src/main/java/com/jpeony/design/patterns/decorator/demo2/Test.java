package com.jpeony.design.patterns.decorator.demo2;

/**
 * @author yihonglei
 */
public class Test {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() +
                "$" + beverage.cost());

        Beverage beverage1 = new HouseBlend();
        Mocha mocha = new Mocha();
        mocha.setBeverage(beverage1);

        System.out.println(mocha.getDescription() +
                "$" + mocha.cost());
    }
}
