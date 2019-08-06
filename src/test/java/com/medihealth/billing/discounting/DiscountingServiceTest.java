package com.medihealth.billing.discounting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiscountingServiceTest {

    @Test(expected = IllegalArgumentException.class)
    public void testAgeDiscountFailure() {
        DiscountingService discountingService = new BasicDiscountingService();
        discountingService.getAgeBasedDiscount(-9, 100);
    }

    @Test
    public void testChildDiscount() {
        DiscountingService discountingService = new BasicDiscountingService();
        int ageBasedDiscount = discountingService.getAgeBasedDiscount(3, 100);
        assertEquals(40, ageBasedDiscount);
    }

    @Test
    public void testSenior1Discount() {
        DiscountingService discountingService = new BasicDiscountingService();
        int ageBasedDiscount = discountingService.getAgeBasedDiscount(67, 100);
        assertEquals(60, ageBasedDiscount);
    }

    @Test
    public void testSenior2Discount() {
        DiscountingService discountingService = new BasicDiscountingService();
        int ageBasedDiscount = discountingService.getAgeBasedDiscount(99, 100);
        assertEquals(90, ageBasedDiscount);
    }
}