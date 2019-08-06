package com.medihealth.billing.discounting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiscountingServiceTest {

    @Test
    public void testChildDiscount() {
        DiscountingService discountingService = new BasicDiscountingService();
        int ageBasedDiscount = discountingService.getAgeBasedDiscount(3, 100);
        assertEquals(40, ageBasedDiscount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgeDiscountFailure() {
        DiscountingService discountingService = new BasicDiscountingService();
        discountingService.getAgeBasedDiscount(-9, 100);
    }
}