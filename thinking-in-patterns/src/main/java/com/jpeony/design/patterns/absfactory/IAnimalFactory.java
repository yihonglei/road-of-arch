package com.jpeony.design.patterns.absfactory;

/**
 * 声明一个用于创建抽象产品对象的操作接口
 *
 * @author yihonglei
 */
public interface IAnimalFactory {

    ICat createCat();

    IDog createDog();

}
