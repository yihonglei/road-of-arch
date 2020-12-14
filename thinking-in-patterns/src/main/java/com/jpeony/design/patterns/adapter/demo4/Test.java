package com.jpeony.design.patterns.adapter.demo4;

/**
 * @author yihonglei
 */
public class Test {
    public static void main(String[] args) {
        // 被适配类
        TwoSocket twoSocket = new TwoSocket();

        // 适配器类
        ThreeSocketTarget three = new AdapterSocket(twoSocket);

        // 调用希望的三孔插座，适配器将2孔转化为了客户端希望的3孔插座
        three.wantThreeSocket();
    }
}
