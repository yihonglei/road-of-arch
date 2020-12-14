package com.jpeony.design.patterns.adapter.demo1;

/**
 * 已经存在，具有特殊功能，但是不符合我们已经存在的标准接口
 *
 * @author yihonglei
 */
public class Adaptee {
    public void adapteeMethod() {
        System.out.println("将要被适配的类");
    }
}
