package com.medihealth.billing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedicalServiceTest {

    @Test
    public void testGetCost() {
        MedicalService medicalService = new DiagnisisMedicalService();
        assertEquals(6000, medicalService.getCost());
    }
}