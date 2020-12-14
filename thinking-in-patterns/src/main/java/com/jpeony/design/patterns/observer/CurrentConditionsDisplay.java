package com.jpeony.design.patterns.observer;

/**
 * @author yihonglei
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temprature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temprature, float humidity, float pressure) {
        this.temprature = temprature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionsDisplay:" +
                temprature + "F degress and " + humidity + "% humidity!");
    }

}
