package com.medihealth.billing;

public class EcgTestMedicalService implements MedicalService {

    private static final int COST = 20040;

    @Override
    public int getCost() {
        return COST;
    }
}
