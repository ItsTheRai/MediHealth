package com.medihealth.billing.services;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedicalServiceTest {

    @Test
    public void testGetDiagnosisCost() {
        MedicalService medicalService = new DiagnosisMedicalService();
        assertEquals(6000, medicalService.calculateCost().getValue());
    }

    @Test
    public void testGetXrayCost() {
        MedicalService medicalService = new XrayMedicalService();
        assertEquals(15000, medicalService.calculateCost().getValue());
    }

    @Test
    public void testGetBloodTest() {
        MedicalService medicalService = new BloodTestMedicalService();
        assertEquals(7800, medicalService.calculateCost().getValue());
    }

    @Test
    public void testGetEcgCost() {
        MedicalService medicalService = new EcgMedicalService();
        assertEquals(20040, medicalService.calculateCost().getValue());
    }

    @Test
    public void testGetVaccineCost() {
        MedicalService medicalService = new VaccineMedicalService(5);
        assertEquals(10250, medicalService.calculateCost().getValue());
    }
}