package com.jpeony.design.patterns.chain;

/**
 * ConcreteHandle: 处理所负责的请求。可以访问其后继者。
 * 如果可以处理该请求就处理，不能处理就将该请求转发给其后继者处理。
 *
 * @author yihonglei
 */
public class PMRequestHandle implements RequestHandle {
    RequestHandle rh;

    public PMRequestHandle(RequestHandle rh) {
        this.rh = rh;
    }

    /**
     * 如果项目经理不审批加薪，就找人事部审批离职吧
     */
    @Override
    public void handleRequest(Object request) {
        if (request instanceof AddMoneyRequest) {// 加薪处理
            System.out.println("要加薪，项目经理审批");
        } else {// 离职处理--客户端调用时，构造方法中传入了人事部审批的实例HRRequestHandle
            rh.handleRequest(request);
        }
    }

}
