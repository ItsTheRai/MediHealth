package com.medihealth.billing.services;

public class EcgMedicalService implements MedicalService {

    private static final int COST = 20040;

    @Override
    public int calculateCost() {
        return COST;
    }
}
