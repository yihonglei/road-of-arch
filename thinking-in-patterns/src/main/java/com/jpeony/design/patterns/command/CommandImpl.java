package com.jpeony.design.patterns.command;

/**
 * ConcreteCommand: 创建一个具体命令对象并设定它的接收者。调用接受者相应的操作，以实现Execute。
 *
 * @author yihonglei
 */
public class CommandImpl extends Command {

    public CommandImpl(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.request();
    }

}
