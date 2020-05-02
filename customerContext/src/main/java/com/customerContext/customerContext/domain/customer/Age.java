package com.customerContext.customerContext.domain.customer;

import com.customerContext.customerContext.domain.customer.exceptions.AgeConnotBeloweighteenException;
import com.customerContext.customerContext.domain.shared.ValueObject;

public class Age extends ValueObject {

    private int value;

    public int getValue() {
        return value;
    }

    public Age(int value) throws AgeConnotBeloweighteenException {
        if (value < 18) {
            throw new AgeConnotBeloweighteenException(value);
        }
        this.value = value;
    }

}
