package com.medihealth.billing.discounting;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AgeBasedDiscountingService implements DiscountingService {

    private final static List<Integer> CHILD_RANGE = IntStream.rangeClosed(0, 5).boxed().collect(Collectors.toList());
    private final static List<Integer> SENIOR_1_RANGE = IntStream.rangeClosed(65, 70).boxed().collect(Collectors.toList());
    private final static List<Integer> SENIOR_2_RANGE = IntStream.rangeClosed(90, 125).boxed().collect(Collectors.toList());

    private final static BigDecimal CHILD_DISCOUNT = new BigDecimal("0.40");
    private final static BigDecimal SENIOR_1_DISCOUNT = new BigDecimal("0.60");
    private final static BigDecimal SENIOR_2_DISCOUNT = new BigDecimal("0.90");

    private final int patientAge;

    AgeBasedDiscountingService(int patientAge) {
        this.patientAge = patientAge;
    }

    @Override
    public int getDiscount(int cost) {
        if (patientAge < 0) {
            throw new IllegalArgumentException();
        }

        if (CHILD_RANGE.contains(patientAge)) {
            return CHILD_DISCOUNT.multiply(BigDecimal.valueOf(cost)).intValue();
        } else if (SENIOR_1_RANGE.contains(patientAge)) {
            return SENIOR_1_DISCOUNT.multiply(BigDecimal.valueOf(cost)).intValue();
        } else if (SENIOR_2_RANGE.contains(patientAge)) {
            return SENIOR_2_DISCOUNT.multiply(BigDecimal.valueOf(cost)).intValue();
        }
        throw new IllegalArgumentException();
    }
}