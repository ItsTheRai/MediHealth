package com.medihealth.billing;

public class DiagnisisMedicalService implements MedicalService {

    private final static int COST = 6000;

    @Override
    public int getCost() {
        return COST;
    }
}
