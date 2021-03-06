package com.medihealth.billing;

import com.medihealth.billing.discounting.AgeBasedDiscountingService;
import com.medihealth.billing.insurance.MedihealthInsurance;
import com.medihealth.billing.services.BloodTestMedicalService;
import com.medihealth.billing.services.MedicalService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorTest {

    @Test
    public void treatmentCost() {
        AgeBasedDiscountingService discountingService = new AgeBasedDiscountingService(90);
        PriceCalculator priceCalculator = new PriceCalculator(discountingService, new MedihealthInsurance());

        List<MedicalService> servicesUsed = new ArrayList<>();
        servicesUsed.add(new BloodTestMedicalService());
        Money treatmentCost = priceCalculator.calculateTreatmentCost(servicesUsed);
        assertEquals(663, treatmentCost.getValue());
    }
}