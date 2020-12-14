package com.jpeony.design.patterns.iterator.demo2;

import java.awt.*;

/**
 * @author yihonglei
 */
public class DinerMenu {
    static final int MAX_ITEMS = 6;
    int numberOfIterms = 0;
    MenuItem[] menuItems;

    public Iterator createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}
