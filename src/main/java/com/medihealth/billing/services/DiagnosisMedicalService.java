package com.medihealth.billing.services;

import com.medihealth.billing.Money;

public class DiagnosisMedicalService implements MedicalService {

    private final static Money COST = new Money("GBP", 6000);

    @Override
    public Money calculateCost() {
        return COST;
    }
}
