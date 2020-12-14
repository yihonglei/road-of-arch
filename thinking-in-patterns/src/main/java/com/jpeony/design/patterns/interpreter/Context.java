package com.jpeony.design.patterns.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * Context: 包含解释器之外的一些全局信息
 *
 * @author yihonglei
 */
public class Context {
    private String context;

    private List list = new ArrayList();

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void add(Expression eps) {
        list.add(eps);
    }


}
