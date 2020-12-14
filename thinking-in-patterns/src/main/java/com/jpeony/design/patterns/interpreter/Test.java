package com.jpeony.design.patterns.interpreter;

/**
 * Client: 调用解释器
 *
 * @author yihonglei
 */
public class Test {
    public static void main(String[] args) {
        Context ctx = new Context();
        ctx.add(new SimpleExpression());
        ctx.add(new AdvanceExpression());
        ctx.add(new SimpleExpression());

        for (int i = 0; i < ctx.getList().size(); i++) {
            Expression eps = (Expression) ctx.getList().get(i);
            eps.interpret(ctx);
        }
    }
}
