package com.medihealth.billing.discounting;

import com.medihealth.billing.Money;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiscountingServiceTest {

    @Test(expected = IllegalArgumentException.class)
    public void testAgeDiscountFailure() {
        DiscountingService discountingService = new AgeBasedDiscountingService(-9);
        discountingService.getDiscount(getMoney());
    }

    private Money getMoney() {
        return new Money("GBP", 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testImpossibleAgeFailure() {
        DiscountingService discountingService = new AgeBasedDiscountingService(150);
        discountingService.getDiscount(getMoney());
    }

    @Test
    public void testChildDiscount() {
        DiscountingService discountingService = new AgeBasedDiscountingService(3);
        Money ageBasedDiscount = discountingService.getDiscount(getMoney());
        assertEquals(40, ageBasedDiscount.getValue());
    }

    @Test
    public void testSenior1Discount() {
        DiscountingService discountingService = new AgeBasedDiscountingService(67);
        Money ageBasedDiscount = discountingService.getDiscount(getMoney());
        assertEquals(60, ageBasedDiscount.getValue());
    }

    @Test
    public void testSenior2Discount() {
        DiscountingService discountingService = new AgeBasedDiscountingService(99);
        Money ageBasedDiscount = discountingService.getDiscount(getMoney());
        assertEquals(90, ageBasedDiscount.getValue());
    }
}