package com.jpeony.algorithm.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代器。
 *
 * @author yihonglei
 */
public class IteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("" + i);
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
