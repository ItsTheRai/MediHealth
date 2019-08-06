package com.medihealth.billing.discounting;

import com.medihealth.billing.Money;

public interface DiscountingService {

    Money getDiscount(Money cost);
}
