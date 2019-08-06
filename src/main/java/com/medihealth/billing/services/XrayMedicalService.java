package com.medihealth.billing.services;

public class XrayMedicalService implements MedicalService {

    private static final int COST = 15000;

    @Override
    public int calculateCost() {
        return COST;
    }
}
