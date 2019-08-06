package com.medihealth.billing.discounting;

import com.medihealth.billing.services.BloodTestMedicalService;
import com.medihealth.billing.services.EcgMedicalService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsuranceTest {

    @Test
    public void testInsuranceDiscount() {
        Insurance discountingService = new MedihealthInsurance();
        int discount = discountingService.calculateDiscount(new BloodTestMedicalService());
        assertEquals(1170, discount);
    }

    @Test
    public void testNoInsuranceDiscount() {
        Insurance discountingService = new MedihealthInsurance();
        int discount = discountingService.calculateDiscount(new EcgMedicalService());
        assertEquals(20040, discount);
    }
}