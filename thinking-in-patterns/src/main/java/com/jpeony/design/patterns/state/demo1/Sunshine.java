package com.jpeony.design.patterns.state.demo1;

/**
 * ContextState: 每一子类实现一个与Context的一个状态相关的行为
 *
 * @author yihonglei
 */
public class Sunshine implements Weather {
    @Override
    public String getWeather() {
        return "红日照耀大地红";
    }
}
