package com.medihealth.billing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedicalServiceTest {

    @Test
    public void testGetDiagnosisCost() {
        MedicalService medicalService = new DiagnisisMedicalService();
        assertEquals(6000, medicalService.getCost());
    }

    @Test
    public void testGetXrayCost(){
        MedicalService medicalService = new XrayMedicalService();
        assertEquals(15000, medicalService.getCost());
    }
}