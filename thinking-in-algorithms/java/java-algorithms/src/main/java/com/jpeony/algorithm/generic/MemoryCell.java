package com.jpeony.algorithm.generic;

/**
 * @author yihonglei
 */
public class MemoryCell {
    // Private internal data representation
    private Object storedValue;

    // Public Methods
    public Object read() {
        return storedValue;
    }

    public void write(Object x) {
        this.storedValue = x;
    }
}
