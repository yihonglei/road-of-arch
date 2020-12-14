package com.jpeony.design.patterns.absfactory;

/**
 * 创建'白色动物'的具体实现工厂
 *
 * @author yihonglei
 */
public class WhiteAnimalFactory implements IAnimalFactory {

    @Override
    public ICat createCat() {
        return new WhiteCat();
    }

    @Override
    public IDog createDog() {
        return new WhiteDog();
    }
}
