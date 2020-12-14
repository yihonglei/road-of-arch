package com.jpeony.design.patterns.facade;

/**
 * Facade: 外观核心，负责处理客户端的请求给合适的子系统对象
 *
 * @author yihonglei
 */
public class SwitchFacade {
    /**
     * 外观模式所有遇到的组件都放在这里
     */
    LightService ls;
    TelevisionService ts;

    public SwitchFacade() {
        ls = new LightServiceImpl();
        ts = new TelevisionServiceImpl();
    }

    public void open() {
        ls.openLight();
        ts.openTelevision();
    }

    public void off() {
        ls.offLight();
        ts.offTelevision();
    }
}
