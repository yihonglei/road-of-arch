package com.jpeony.design.patterns.iterator.demo1;

/**
 * Iterator：迭代器定义访问和遍历元素的接口
 *
 * @author yihonglei
 */
public interface Iterator {
    Object next();

    void first();

    void last();

    boolean hasNext();
}
