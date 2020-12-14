package com.jpeony.design.patterns.facade;

/**
 * Client负责调用facade,facade负责分派任务，SubSystemClass负责执行facade分派的任务
 *
 * @author yihonglei
 */
public class Test {
    public static void main(String[] args) {
        SwitchFacade facade = new SwitchFacade();

        /*
         * Client
         */
        facade.open();
        System.out.println("=======================");
        facade.off();
    }
}
