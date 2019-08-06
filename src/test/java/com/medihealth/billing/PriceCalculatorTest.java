package com.medihealth.billing;

import com.medihealth.billing.discounting.AgeBasedDiscountingService;
import com.medihealth.billing.discounting.MedihealthInsurance;
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
        int treatmentCost = priceCalculator.treatmentCost(servicesUsed);
        assertEquals(663, treatmentCost);
        System.out.println(treatmentCost);
    }
}