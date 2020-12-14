package com.jpeony.design.patterns.adapter.demo2;

/**
 * @author yihonglei
 */
public class TurkeyDriveTest {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        DuckAdapter duckAdapter = new DuckAdapter(duck);

        duckAdapter.gobble();
        duckAdapter.fly();
    }
}
