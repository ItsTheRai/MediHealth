package com.medihealth.billing.discounting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiscountingServiceTest {

    @Test(expected = IllegalArgumentException.class)
    public void testAgeDiscountFailure() {
        DiscountingService discountingService = new BasicDiscountingService();
        discountingService.getDiscount(-9, 100);
    }

    @Test
    public void testChildDiscount() {
        DiscountingService discountingService = new BasicDiscountingService();
        int ageBasedDiscount = discountingService.getDiscount(3, 100);
        assertEquals(40, ageBasedDiscount);
    }

    @Test
    public void testSenior1Discount() {
        DiscountingService discountingService = new BasicDiscountingService();
        int ageBasedDiscount = discountingService.getDiscount(67, 100);
        assertEquals(60, ageBasedDiscount);
    }

    @Test
    public void testSenior2Discount() {
        DiscountingService discountingService = new BasicDiscountingService();
        int ageBasedDiscount = discountingService.getDiscount(99, 100);
        assertEquals(90, ageBasedDiscount);
    }

    @Test
    public void testInsuranceDiscount() {
        DiscountingService discountingService = new BasicDiscountingService();
    }
}