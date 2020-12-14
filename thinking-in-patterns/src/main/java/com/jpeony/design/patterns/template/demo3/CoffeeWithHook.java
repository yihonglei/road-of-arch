package com.jpeony.design.patterns.template.demo3;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: CoffeeWithHook
 * @Package: com.lanhuigu.design.template.demo3
 * @date 2018/3/20 18:04
 */
/**
 *
 * @author yihonglei
 * @date 2018/8/21 10:20
 */
public class CoffeeWithHook extends CaffeineBeverageWithHook {

    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    /** 重写钩子,改变算法的实现 */
    @Override
    public boolean customerWantsCondiments() {
        return false;
    }
}
