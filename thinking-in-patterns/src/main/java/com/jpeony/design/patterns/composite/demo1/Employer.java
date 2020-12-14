package com.jpeony.design.patterns.composite.demo1;

import java.util.List;

/**
 * Component: 管理和访问子子部件的接口--这里用于管理公司员工
 *
 * @author yihonglei
 */
public abstract class Employer {
    /**
     * 员工集合
     */
    List employers;

    /**
     * 员工职位名称
     */
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 添加员工
     */
    public abstract void add(Employer employer);

    /**
     * 删除员工
     */
    public abstract void delete(Employer employer);

    /**
     * 员工列表
     */
    public List getEmployers() {
        return employers;
    }
}
