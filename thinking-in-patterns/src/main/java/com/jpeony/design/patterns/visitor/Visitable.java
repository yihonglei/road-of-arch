package com.jpeony.design.patterns.visitor;

/**
 * Element: 定义一个Accept操作，它以一个访问者为参数。
 *
 * @author yihonglei
 */
public interface Visitable {
    void accept(Visitor visitor);
}