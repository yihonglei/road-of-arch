package com.jpeony.design.patterns.builder;

/**
 * @author yihonglei
 */
public class WhiteCatBuilder implements CatBuilder {
    private Cat cat;

    public WhiteCatBuilder() {
        cat = new WhiteCat();
    }

    @Override
    public void buildHead() {
        cat.setHead("--白头--");
        System.out.println("方法:建造白猫头");
    }

    @Override
    public void buildBody() {
        cat.setBody("--白体--");
        System.out.println("方法:建造白猫身体");
    }

    @Override
    public void buildFoot() {
        cat.setFoot("--白脚--");
        System.out.println("方法:建造白猫脚");
    }

    @Override
    public Cat buildCat() {
        return cat;
    }
}
