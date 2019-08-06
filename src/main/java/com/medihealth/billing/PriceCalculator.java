package com.medihealth.billing;

import com.medihealth.billing.discounting.DiscountingService;
import com.medihealth.billing.insurance.Insurance;
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
     * Calculate the cost of the services taking into account discounting
     *
     * @param servicesUsed medical services used by the patient
     * @return the total sum of all treatment costs, as a fractional monetary unit
     */
    public Money calculateTreatmentCost(List<MedicalService> servicesUsed) {
        return servicesUsed.stream()
                .map(this::getCost)
                .reduce(Money::add)
                .orElse(null);
    }

    private Money getCost(MedicalService service) {
        Money baseCost = service.calculateCost();
        Money costWithDiscount = baseCost.subtract(discountingService.getDiscount(baseCost));
        return costWithDiscount.subtract(getInsuranceDiscount(service, costWithDiscount));
    }

    private Money getInsuranceDiscount(MedicalService service, Money discountCost) {
        return new Money(discountCost.getCurrency(),
                insurance.calculateDiscount(service).multiply(BigDecimal.valueOf(discountCost.getValue())).intValue());
    }
}
