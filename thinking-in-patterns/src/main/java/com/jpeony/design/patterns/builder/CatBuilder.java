package com.jpeony.design.patterns.builder;

/**
 * @author yihonglei
 */
public interface CatBuilder {
    void buildHead();

    void buildBody();

    void buildFoot();

    Cat buildCat();
}
