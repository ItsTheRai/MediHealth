package com.medihealth.billing;

import com.medihealth.billing.discounting.DiscountingService;
import com.medihealth.billing.discounting.Insurance;
import com.medihealth.billing.services.MedicalService;

import java.math.BigDecimal;
import java.util.List;

class PriceCalculator {

    private final DiscountingService discountingService;

    private final Insurance insurance;


    PriceCalculator(DiscountingService discountingService, Insurance insurance) {
        this.discountingService = discountingService;
        this.insurance = insurance;
    }

    public int treatmentCost(List<MedicalService> servicesUsed) {
        return servicesUsed.stream()
                .reduce(0, (serviceCost, nextService) -> serviceCost + getCost(nextService), Integer::sum);
    }

    private int getCost(MedicalService service) {
        int baseCost = service.calculateCost();
        int discountCost = baseCost - discountingService.getDiscount(baseCost);
        return discountCost - insurance.calculateDiscount(service).multiply(BigDecimal.valueOf(discountCost)).intValue();
    }
}
