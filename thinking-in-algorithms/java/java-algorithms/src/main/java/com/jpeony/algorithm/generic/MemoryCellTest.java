package com.jpeony.algorithm.generic;

/**
 * @author yihonglei
 */
public class MemoryCellTest {
    public static void main(String[] args) {
        MemoryCell m = new MemoryCell();

        m.write("37");

        String val = (String) m.read();
        System.out.println("Contents are:" + val);
    }
}