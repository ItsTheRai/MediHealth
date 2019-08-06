package com.medihealth.billing.insurance;

import com.medihealth.billing.insurance.Insurance;
import com.medihealth.billing.insurance.MedihealthInsurance;
import com.medihealth.billing.services.BloodTestMedicalService;
import com.medihealth.billing.services.EcgMedicalService;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class InsuranceTest {

    @Test
    public void testInsuranceDiscount() {
        Insurance discountingService = new MedihealthInsurance();
        BigDecimal discount = discountingService.calculateDiscount(new BloodTestMedicalService());
        assertEquals(new BigDecimal("0.15"), discount);
    }

    @Test
    public void testNoInsuranceDiscount() {
        Insurance discountingService = new MedihealthInsurance();
        BigDecimal discount = discountingService.calculateDiscount(new EcgMedicalService());
        assertEquals(new BigDecimal("0"), discount);
    }
}