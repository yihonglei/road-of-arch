package com.jpeony.design.patterns.facade;

/**
 * @author yihonglei
 */
public class TelevisionServiceImpl implements TelevisionService {
    @Override
    public void openTelevision() {
        System.out.println("下班的时候打开电视，看电视");
    }

    @Override
    public void offTelevision() {
        System.out.println("上班的时候关掉电视，去上班");
    }
}
