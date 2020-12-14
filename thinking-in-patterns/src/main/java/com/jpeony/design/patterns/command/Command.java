package com.jpeony.design.patterns.command;

/**
 * Command:声明执行操作的接口。调用接收者相应的操作，以实现执行的方法Execute。
 *
 * @author yihonglei
 */
public abstract class Command {
    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();
}
