package com.jpeony.design.patterns.visitor;

/**
 * ConcreteElement: 实现Accept操作，该操作以一个访问者为参数。
 *
 * @author yihonglei
 */
public class StringElement implements Visitable {
    private String se;

    public StringElement(String se) {
        this.se = se;
    }

    public String getSe() {
        return se;
    }

    public void setSe(String se) {
        this.se = se;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitString(this);
    }

}