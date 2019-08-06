package com.medihealth.billing.services;

import com.medihealth.billing.Money;

public class VaccineMedicalService implements MedicalService {

    private static final Money SERVICE_COST = new Money("GBP", 2750);

    private static final Money VACCINE_COST = new Money("GBP", 1500);

    private final int vaccineCount;

    VaccineMedicalService(int vaccineCount) {
        this.vaccineCount = vaccineCount;
    }

    @Override
    public Money calculateCost() {
        return SERVICE_COST.add(VACCINE_COST.multiply(vaccineCount));
    }
}
