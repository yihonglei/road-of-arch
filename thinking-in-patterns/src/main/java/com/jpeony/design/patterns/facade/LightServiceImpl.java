package com.jpeony.design.patterns.facade;

/**
 * @author yihonglei
 */
public class LightServiceImpl implements LightService {
    @Override
    public void openLight() {
        System.out.println("天黑了，开灯");
    }

    @Override
    public void offLight() {
        System.out.println("天亮了，关灯");
    }
}
