package com.jpeony.design.patterns.facade;

/**
 * 子系统接口功能
 *
 * @author yihonglei
 */
public interface LightService {
    /**
     * 开灯
     */
    void openLight();

    /**
     * 关灯
     */
    void offLight();
}
