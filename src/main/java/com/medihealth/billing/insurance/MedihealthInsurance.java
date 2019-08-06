package com.medihealth.billing.insurance;

import com.medihealth.billing.services.BloodTestMedicalService;
import com.medihealth.billing.services.MedicalService;

import java.math.BigDecimal;

public class MedihealthInsurance implements Insurance {

    private static final BigDecimal DISCOUNT = new BigDecimal("0.15");

    @Override
    public BigDecimal calculateDiscount(MedicalService service) {
        if (service instanceof BloodTestMedicalService) {
            return DISCOUNT;
        }
        return new BigDecimal("0");
    }
}
