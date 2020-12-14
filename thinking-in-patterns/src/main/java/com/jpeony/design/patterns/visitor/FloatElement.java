package com.jpeony.design.patterns.visitor;

/**
 * ConcreteElement: 实现Accept操作，该操作以一个访问者为参数。
 *
 * @author yihonglei
 */
public class FloatElement implements Visitable {
    private Float fe;

    public FloatElement(Float fe) {
        this.fe = fe;
    }

    public Float getFe() {
        return fe;
    }

    public void setFe(Float fe) {
        this.fe = fe;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFloat(this);
    }

}