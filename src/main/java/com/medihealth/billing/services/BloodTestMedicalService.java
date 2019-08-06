package com.medihealth.billing.services;

import com.medihealth.billing.Money;

public class BloodTestMedicalService implements MedicalService {

    private static final Money COST = new Money("GBP", 7800);

    @Override
    public Money calculateCost() {
        return COST;
    }
}
