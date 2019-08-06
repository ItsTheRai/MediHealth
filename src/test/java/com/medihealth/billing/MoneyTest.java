package com.medihealth.billing;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MoneyTest {

    @Test(expected = IllegalArgumentException.class)
    public void subtractErrorTest() {
        Money money1 = new Money("GBP", 100);
        Money money2 = new Money("GBP", 101);
        money1.subtract(money2);
    }

    @Test
    public void subtractTest() {
        Money money1 = new Money("GBP", 100);
        Money money2 = new Money("GBP", 12);
        Money result = money1.subtract(money2);
        assertEquals(new Money("GBP", 88), result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addErrorTest() {
        Money money1 = new Money("GBP", 100);
        Money money2 = new Money("AFW", 101);
        money1.add(money2);
    }

    @Test
    public void addTest() {
        Money money1 = new Money("GBP", 100);
        Money money2 = new Money("GBP", 101);
        Money result = money1.add(money2);
        assertEquals(new Money("GBP", 201), result);
    }

    @Test
    public void multiplyTestWithInt() {
        Money money1 = new Money("GBP", 100);
        Money result = money1.multiply(5);
        assertEquals(new Money("GBP", 500), result);
    }
    @Test
    public void multiplyTestWithBigDecimal() {
        Money money1 = new Money("GBP", 100);
        BigDecimal multiplicator = new BigDecimal("0.1");
        Money result = money1.multiply(multiplicator);
        assertEquals(new Money("GBP", 10), result);
    }
}