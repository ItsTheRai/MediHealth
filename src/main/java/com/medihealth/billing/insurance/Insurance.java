package com.medihealth.billing.insurance;

import com.medihealth.billing.services.MedicalService;

import java.math.BigDecimal;

public interface Insurance {

    BigDecimal calculateDiscount(MedicalService service);
}
