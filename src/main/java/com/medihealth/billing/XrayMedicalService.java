package com.medihealth.billing;

public class XrayMedicalService implements MedicalService {

    private static final int COST = 15000;

    @Override
    public int getCost() {
        return COST;
    }
}
