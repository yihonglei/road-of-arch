package com.jpeony.design.patterns.absfactory;

/**
 * 创建'黑色动物'的具体实现工厂
 *
 * @author yihonglei
 */
public class BlackAnimalFactory implements IAnimalFactory {
    @Override
    public ICat createCat() {
        return new BlackCat();
    }

    @Override
    public IDog createDog() {
        return new BlackDog();
    }
}
