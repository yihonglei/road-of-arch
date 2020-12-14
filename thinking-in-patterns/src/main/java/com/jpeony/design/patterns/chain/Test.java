package com.jpeony.design.patterns.chain;

/**
 * Client: 发送请求给ConcreteHandle处理的实现对象
 *
 * @author yihonglei
 */
public class Test {
    public static void main(String[] args) {
        RequestHandle hr = new HRRequestHandle();
        RequestHandle pm = new PMRequestHandle(hr);

        Object request = new DimisionRequest();
        hr.handleRequest(request);

        request = new AddMoneyRequest();
        pm.handleRequest(request);
    }
}
