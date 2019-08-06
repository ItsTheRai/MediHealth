package com.medihealth.billing.discounting;

import com.medihealth.billing.services.BloodTestMedicalService;
import com.medihealth.billing.services.MedicalService;

import java.math.BigDecimal;

public class MedihealthInsurance implements Insurance {

    private static final BigDecimal DISCOUNT = new BigDecimal("0.15");

    @Override
    public BigDecimal calculateDiscount(MedicalService service) {
        int serviceBaseCost = service.calculateCost();

        if (service instanceof BloodTestMedicalService) {
            return DISCOUNT;
        }
        return new BigDecimal("0");
    }
}