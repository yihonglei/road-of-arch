package com.jpeony.design.patterns.state.demo1;

/**
 * Context: 定义一个用户感兴趣的接口，维护一个ContereteState实例，这个实例定义当前状态
 *
 * @author yihonglei
 */
public class Context {
    private Weather weather;

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String weatherMessage() {
        return weather.getWeather();
    }
}
