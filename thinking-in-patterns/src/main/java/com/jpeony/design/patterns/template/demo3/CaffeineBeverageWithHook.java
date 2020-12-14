package com.jpeony.design.patterns.template.demo3;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: CaffeineBeverageWithHook
 * @Package: com.lanhuigu.design.template.demo3
 * @date 2018/3/20 17:58
 */
/**
 *
 * @author yihonglei
 * @date 2018/8/21 10:20
 */
public abstract class CaffeineBeverageWithHook {
    /** 模板方法 */
    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        /** 通过钩子改变算法的实现 */
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /** 抽象方法，子类实现 */
    abstract void brew();
    abstract void addCondiments();

    /** 定义一个钩子 */
    boolean customerWantsCondiments() {
        return true;
    }
}
