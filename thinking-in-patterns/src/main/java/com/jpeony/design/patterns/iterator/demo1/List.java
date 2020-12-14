package com.jpeony.design.patterns.iterator.demo1;

/**
 * Aggregate: 聚合定义创建相应迭代器对象的接口
 *
 * @author yihonglei
 */
public interface List {
    Iterator iterator();

    Object get(int index);

    int getSize();

    void add(Object obj);
}
