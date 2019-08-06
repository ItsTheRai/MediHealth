package com.medihealth.billing.discounting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiscountingServiceTest {

    @Test(expected = IllegalArgumentException.class)
    public void testAgeDiscountFailure() {
        DiscountingService discountingService = new AgeBasedDiscountingService(-9);
        discountingService.getDiscount(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testImpossibleAgeFailure() {
        DiscountingService discountingService = new AgeBasedDiscountingService(150);
        discountingService.getDiscount(100);
    }

    @Test
    public void testChildDiscount() {
        DiscountingService discountingService = new AgeBasedDiscountingService(3);
        int ageBasedDiscount = discountingService.getDiscount(100);
        assertEquals(40, ageBasedDiscount);
    }

    @Test
    public void testSenior1Discount() {
        DiscountingService discountingService = new AgeBasedDiscountingService(67);
        int ageBasedDiscount = discountingService.getDiscount(100);
        assertEquals(60, ageBasedDiscount);
    }

    @Test
    public void testSenior2Discount() {
        DiscountingService discountingService = new AgeBasedDiscountingService(99);
        int ageBasedDiscount = discountingService.getDiscount(100);
        assertEquals(90, ageBasedDiscount);
    }
}