package com.jpeony.algorithm.tree;

import java.util.TreeMap;

/**
 * TreeMap，链式存储法
 *
 * @author yihonglei
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();

        treeMap.put("key1", "value1");

        treeMap.put("key2", "value2");

        treeMap.put("key3", "value3");

        System.out.println(treeMap.get("key1"));
    }
}
