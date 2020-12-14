package com.jpeony.algotithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yihonglei
 */
public class Test {
    public static void main(String[] args) {
        List<String> arrList = new ArrayList<>();
        arrList.add("1");
        arrList.add("2");
        arrList.add("3");
        arrList.add("4");
        arrList.add("5");

        List<String> arrListNew = arrList.subList(0, Math.min(arrList.size(), 4));
        for (String str : arrListNew) {
            System.out.println("str:" + str);
        }
    }
}
