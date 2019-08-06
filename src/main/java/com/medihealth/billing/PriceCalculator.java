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

    /**
     * Calculate the cost of the services taking into account the discounting
     *
     * @param servicesUsed medical services used by the patient
     * @return the total sum of all treatment costs, as a fractional monetary unit
     */
    public int treatmentCost(List<MedicalService> servicesUsed) {
        return servicesUsed.stream()
                .reduce(0, (serviceCost, nextService) -> serviceCost + getCost(nextService), Integer::sum);
    }

    private int getCost(MedicalService service) {
        int baseCost = service.calculateCost();
        int costWithDiscount = baseCost - discountingService.getDiscount(baseCost);
        return costWithDiscount - getInsuranceDiscount(service, costWithDiscount);
    }

    private int getInsuranceDiscount(MedicalService service, int discountCost) {
        return insurance.calculateDiscount(service).multiply(BigDecimal.valueOf(discountCost)).intValue();
    }
}
