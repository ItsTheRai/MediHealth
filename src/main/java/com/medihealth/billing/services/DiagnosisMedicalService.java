package com.medihealth.billing.services;

public class DiagnosisMedicalService implements MedicalService {

    private final static int COST = 6000;

    @Override
    public int calculateCost() {
        return COST;
    }
}
