package com.jpeony.design.patterns.template.demo3;

/**
 * 什么时候使用抽象，什么时候使用钩子？
 * 1. 当算法实现不可变时，使用抽象;
 * 2. 当算法实现部分是可选的时候，使用钩子;
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Test
 * @Package: com.lanhuigu.design.template.demo3
 * @date 2018/3/20 18:19
 */
/**
 *
 * @author yihonglei
 * @date 2018/8/21 10:20
 */
public class Test {
    public static void main(String[] args) {
        CoffeeWithHook coffeeWithHook = new CoffeeWithHook();
        coffeeWithHook.prepareRecipe();
    }
}
