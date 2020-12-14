package com.jpeony.design.patterns.observer;

/**
 * @author yihonglei
 */
public class Test {

    public static void main(String[] args) {
        // 先将观察者注册到目标中的观察者列表
        Policeman pol = new BeiJingPoliceman();
        Citizen ci = new BeiJingCitizen(pol);

        // 目标变动时，目标的通知方法会通知观察者
        ci.sendMessage("normal");
    }

}
