package com.jpeony.design.patterns.iterator.demo1;

/**
 * ConcreteAggregate: 具体聚合实现创建相应迭代器的接口，该操作返回ConcreteIterator的一个适当的实例
 *
 * @author yihonglei
 */
public class ListImpl implements List {
    private Object[] list;
    private int index;
    private int size;

    public ListImpl() {
        index = 0;
        size = 0;
        list = new Object[100];
    }

    @Override
    public Iterator iterator() {
        return new IteratorImpl(this);
    }

    @Override
    public Object get(int index) {
        return list[index];
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void add(Object obj) {
        list[index++] = obj;
        size++;
    }
}
