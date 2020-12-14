package com.jpeony.design.patterns.template.demo2;

/**
 * 抽象类作为基类，其子类必须实现其操作。
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: CaffeineBevergeAbstract
 * @Package: com.lanhuigu.design.template.demo2
 * @date 2018/3/20 12:49
 */
/**
 *
 * @author yihonglei
 * @date 2018/8/21 10:20
 */
public abstract class CaffeineBevergeAbstract {
    /**
     * 模板方法
     * @author yihonglei
     * @date 2018/3/20 15:26
     * @params 
     * @return 
     * @throws 
     * @since 1.0.0
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    protected void boilWater() {
        System.out.println("Boiling water");
    }

    protected void addCondiments() {
        System.out.println("Pouring into cup");
    }

    /** 由子类实现其抽象方法 */
    protected abstract void brew();
    protected abstract void pourInCup();
}
