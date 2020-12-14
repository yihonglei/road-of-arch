package com.jpeony.design.patterns.adapter.demo4;

/**
 * @author yihonglei
 */
public class AdapterSocket implements ThreeSocketTarget {
    private TwoSocket twoSocket;

    public AdapterSocket(TwoSocket twoSocket) {
        this.twoSocket = twoSocket;
    }

    @Override
    public void wantThreeSocket() {
        twoSocket.adapteeMethod();
    }
}
