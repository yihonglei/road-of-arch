package com.jpeony.design.patterns.builder;

/**
 * @author yihonglei
 */
public class BuilderTest {
    public static void main(String[] args) {
        CatDirector cd = new CatDirector();
        Cat cat = cd.constructCat(new WhiteCatBuilder());
        System.out.println(cat.getHead());
        System.out.println(cat.getBody());
        System.out.println(cat.getFoot());
    }
}
