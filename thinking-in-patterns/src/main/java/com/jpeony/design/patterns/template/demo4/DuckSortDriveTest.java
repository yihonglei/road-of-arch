package com.jpeony.design.patterns.template.demo4;

import java.util.Arrays;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: DuckSortDriveTest
 * @Package: com.lanhuigu.design.template.demo4
 * @date 2018/3/20 20:23
 */
/**
 *
 * @author yihonglei
 * @date 2018/8/21 10:20
 */
public class DuckSortDriveTest {
    public static void main(String[] args) {
        Duck[] ducks = {
                new Duck("Daffy", 8),
                new Duck("Dewey", 2)
        };

        System.out.println("Before sorting:");
        display(ducks);

        Arrays.sort(ducks);

        System.out.println("\nAfter sorting:");
        display(ducks);
    }

    private static void display(Duck[] ducks) {
        for (int i = 0; i < ducks.length; i++) {
            System.out.println(ducks[i]);
        }
    }
}
