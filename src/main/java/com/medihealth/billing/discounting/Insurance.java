package com.medihealth.billing.discounting;

import com.medihealth.billing.services.MedicalService;

import java.math.BigDecimal;

public interface Insurance {

    BigDecimal calculateDiscount(MedicalService service);
}
