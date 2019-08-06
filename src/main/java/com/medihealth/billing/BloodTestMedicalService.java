package com.medihealth.billing;

public class BloodTestMedicalService implements MedicalService {

    private static final int COST = 7800;

    @Override
    public int getCost() {
        return COST;
    }
}
