package com.medihealth.billing.services;

public class VaccineMedicalService implements MedicalService {

    private static final int SERVICE_COST = 2750;

    private static final int VACCINE_COST = 1500;

    private final int vaccineCount;

    VaccineMedicalService(int vaccineCount) {
        this.vaccineCount = vaccineCount;
    }

    @Override
    public int calculateCost() {
        return SERVICE_COST + VACCINE_COST * vaccineCount;
    }
}
