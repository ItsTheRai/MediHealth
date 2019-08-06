package com.medihealth.billing.discounting;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class BasicDiscountingService implements DiscountingService {

    private final static IntStream child_range = IntStream.rangeClosed(0, 5);

    private final static BigDecimal CHILD_DISCOUNT = new BigDecimal("0.40");

    @Override
    public int getAgeBasedDiscount(int age, int cost) {
        if (age < 0) {
            throw new IllegalArgumentException();
        }

        if (child_range.anyMatch(value -> value == age)) {
            return CHILD_DISCOUNT.multiply(BigDecimal.valueOf(cost)).intValue();
        }
        throw new IllegalArgumentException();
    }
}
