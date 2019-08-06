package com.medihealth.billing.services;

public class BloodTestMedicalService implements MedicalService {

    private static final int COST = 7800;

    @Override
    public int calculateCost() {
        return COST;
    }
}
