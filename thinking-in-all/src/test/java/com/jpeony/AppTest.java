package com.jpeony;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal(Float.valueOf(3763023 / 60000));
        b.setScale(BigDecimal.ROUND_UP, 2);
        System.out.println(b);
    }
}
