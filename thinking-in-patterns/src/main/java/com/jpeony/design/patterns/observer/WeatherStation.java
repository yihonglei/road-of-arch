package com.jpeony.design.patterns.observer;

/**
 * @author yihonglei
 */
public class WeatherStation {
    public static void main(String[] args) {
        // 主题
        WeatherData weatherData = new WeatherData();

        // 注册到主题的观察者列表
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

        // 测试，当主题变化时根据观察者列表通知观察者
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
