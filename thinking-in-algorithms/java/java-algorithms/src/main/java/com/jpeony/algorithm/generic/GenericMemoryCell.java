package com.jpeony.algorithm.generic;

/**
 * 泛型类声明
 *
 * @author yihonglei
 */
public class GenericMemoryCell<AnyType> {
    private AnyType storedValue;

    public AnyType read() {
        return storedValue;
    }

    public void write(AnyType x) {
        storedValue = x;
    }
}
