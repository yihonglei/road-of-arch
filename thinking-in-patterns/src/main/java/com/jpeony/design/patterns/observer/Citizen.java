package com.jpeony.design.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标(主题)
 *
 * @author yihonglei
 */
public abstract class Citizen {
    List pols;
    String help = "normal";

    /**
     * 注册观察者
     */
    public void register(Policeman pol) {
        this.pols.add(pol);
    }

    /**
     * 解绑观察者
     */
    public void unRegister(Policeman pol) {
        this.pols.remove(pol);
    }

    /**
     * 通知观察者
     */
    abstract void sendMessage(String help);

    /**
     * 提供一个公用方法，创建观察者列表
     */
    public void setPoliceman() {
        this.pols = new ArrayList<>();
    }

    public List getPols() {
        return pols;
    }

    public void setPols(List pols) {
        this.pols = pols;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

}
