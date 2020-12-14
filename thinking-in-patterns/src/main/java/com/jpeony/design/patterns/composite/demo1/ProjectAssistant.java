package com.jpeony.design.patterns.composite.demo1;

/**
 * Leaf: 组合对象的叶节点对象，叶节点对象没有字节点对象，并且定义了叶节点对象的行为
 *
 * @author yihonglei
 */
public class ProjectAssistant extends Employer {

    public ProjectAssistant(String name) {
        setName(name);
        employers = null;
    }

    @Override
    public void add(Employer employer) {
        System.out.println("添加项目助理叶节点");
    }

    @Override
    public void delete(Employer employer) {
        System.out.println("删除项目助理叶节点");
    }

}
