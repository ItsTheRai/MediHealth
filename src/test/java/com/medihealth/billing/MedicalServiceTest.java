package com.medihealth.billing;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedicalServiceTest {

    @Test
    public void testGetCost()
    {
        MedicalService medicalService = new DiagnisisMedicalService();
        assertEquals(10123321, medicalService.getCost());
    }
}