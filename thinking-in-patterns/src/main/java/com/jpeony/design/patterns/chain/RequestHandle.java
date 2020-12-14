package com.jpeony.design.patterns.chain;

/**
 * Handler: 处理请求的接口。（可选）实现后继链，这里没有实现。
 *
 * @author yihonglei
 */
public interface RequestHandle {

    void handleRequest(Object request);
}
