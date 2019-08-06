package com.medihealth.billing.discounting;

import com.medihealth.billing.services.MedicalService;

public interface Insurance {

    int calculateDiscount(MedicalService service);
}
