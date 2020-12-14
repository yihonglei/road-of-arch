package com.jpeony.design.patterns.command;

/**
 * Client: 创建一个具体的命令对象，并且设置命令对象的接收者。
 *
 * @author yihonglei
 */
public class Test {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new CommandImpl(receiver);

        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.execute();// 调用者调用，接受者接受
    }
}

