package com.jpeony.design.patterns.composite.demo1;

import java.util.List;

/**
 * @author yihonglei
 * @date 2018/8/21 10:20
 */
public class Test {
    public static void main(String[] args) {
        // 公司招了一个项目经理
        Employer projectManager = new ProjectManager("项目经理");
        // 公司为项目经理招了一个助理
        Employer projectAssisnant = new ProjectAssistant("项目助理");

        // 又招了一个码农
        Employer programmerOne = new Programmer("码农1");
        // 一个不够，又给招了一个，都归项目经理管理
        Employer programmerTwo = new Programmer("码农2");

        // 给项目经理添加助理
        projectManager.add(projectAssisnant);
        // 给项目经理添加码农1
        projectManager.add(programmerOne);
        // 给项目经理添加码农2
        projectManager.add(programmerTwo);

        List ems = projectManager.getEmployers();

        for (int i = 0; i < ems.size(); i++) {
            Employer em = (Employer) ems.get(i);
            System.out.println(em.getName());
        }
    }
}
