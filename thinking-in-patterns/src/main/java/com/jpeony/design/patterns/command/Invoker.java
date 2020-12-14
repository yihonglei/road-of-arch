package com.jpeony.design.patterns.command;

/**
 * Invoker: 要求该命令执行这个请求。通常会持有命令对象，可以持有很多的命令对象。
 *
 * @author yihonglei
 */
public class Invoker {
    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }
}
