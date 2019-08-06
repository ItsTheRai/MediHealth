package com.medihealth.billing;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private final String currency;

    private final int value;

    public Money(String currency, int value) {
        this.currency = currency;
        this.value = value;
    }

    Money subtract(Money discount) {
        if (!this.currency.equals(discount.getCurrency()) || this.value < discount.getValue()) {
            throw new IllegalArgumentException();
        }
        return new Money(this.currency, this.value - discount.getValue());
    }

    public Money add(Money value) {
        if (!this.currency.equals(value.getCurrency())) {
            throw new IllegalArgumentException();
        }
        return new Money(this.currency, this.value + value.getValue());
    }

    public Money multiply(BigDecimal multiplier) {
        return new Money(this.currency, multiplier.multiply(BigDecimal.valueOf(this.value)).intValue());
    }

    public Money multiply(int multiplier) {
        return new Money(this.currency, this.value * multiplier);
    }

    String getCurrency() {
        return currency;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value &&
                currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, value);
    }
}
