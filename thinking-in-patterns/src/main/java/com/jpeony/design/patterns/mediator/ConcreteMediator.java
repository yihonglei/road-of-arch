package com.jpeony.design.patterns.mediator;

/**
 * ConcreteMediator: 具体中介者通过协调各同事对象实现协作行为，了解并维护同事对象
 *
 * @author yihonglei
 */
public class ConcreteMediator extends Mediator {
    private ColleagueA ca;
    private ColleagueB cb;

    public ConcreteMediator() {
        ca = new ColleagueA();
        cb = new ColleagueB();
    }

    @Override
    void notice(String context) {
        if ("A特工".equals(context)) {
            ca.action();
        }
        if ("B特工".equals(context)) {
            cb.action();
        }
    }

}
