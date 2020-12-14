package com.jpeony.design.patterns.chain;

/**
 * ConcreteHandle: 处理所负责的请求。可以访问其后继者。
 * 如果可以处理该请求就处理，不能处理就将该请求转发给其后继者处理。
 *
 * @author yihonglei
 */
public class HRRequestHandle implements RequestHandle {

    @Override
    public void handleRequest(Object request) {
        if (request instanceof DimisionRequest) {
            System.out.println("要离职，人事部门审批");
        }
    }

}
