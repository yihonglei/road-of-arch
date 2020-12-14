package com.jpeony.design.patterns.observer;

/**
 * 目标具体实现
 *
 * @author yihonglei
 */
public class BeiJingCitizen extends Citizen {

    public BeiJingCitizen(Policeman pol) {
        setPoliceman();
        register(pol);
    }

    @Override
    void sendMessage(String help) {
        setHelp(help);
        for (int i = 0; i < pols.size(); i++) {
            Policeman pol = (Policeman) pols.get(i);
            pol.action(this);
        }
    }

}
