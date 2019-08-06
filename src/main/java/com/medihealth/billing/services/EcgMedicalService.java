package com.medihealth.billing.services;

import com.medihealth.billing.Money;

public class EcgMedicalService implements MedicalService {

    private static final Money COST = new Money("GBP", 20040);

    @Override
    public Money calculateCost() {
        return COST;
    }
}
