package com.jpeony.design.patterns.proxy.demo1;

/**
 * @author yihonglei
 */
public class GumballMonitor {
    GumballMachine machine;

    public GumballMonitor(GumballMachine machine) {
        this.machine = machine;
    }

    public void report() {
        System.out.println("Gumball Machine: " + machine.getLocation());
    }
}
