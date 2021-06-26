package com.jpeony.algorithm.hash;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yihonglei
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<Integer,String> map = new LinkedHashMap<>();
        map.put(6, "apple");
        map.put(3, "banana");
        map.put(2,"pear");

        map.get(6);
    }
}
