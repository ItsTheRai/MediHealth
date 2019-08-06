package com.medihealth.billing.services;

import com.medihealth.billing.Money;

public class XrayMedicalService implements MedicalService {

    private static final Money COST = new Money("GBP", 15000);

    @Override
    public Money calculateCost() {
        return COST;
    }
}
