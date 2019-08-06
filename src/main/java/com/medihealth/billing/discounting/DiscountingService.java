package com.medihealth.billing.discounting;

public interface DiscountingService {

    int getAgeBasedDiscount(int age, int cost);
}
