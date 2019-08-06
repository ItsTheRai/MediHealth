package com.medihealth.billing;

public class VaccineTestMedicalServce implements MedicalService {

    private static final int SERVICE_COST = 2750;

    private static final int VACCINE_COST = 1500;

    private final int vaccineCount;

    VaccineTestMedicalServce(int vaccineCount) {
        this.vaccineCount = vaccineCount;
    }

    @Override
    public int getCost() {
        return SERVICE_COST + VACCINE_COST * vaccineCount;
    }
}
