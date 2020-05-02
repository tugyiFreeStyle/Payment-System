package com.customerContext.customerContext.domain.customer;

import com.customerContext.customerContext.domain.shared.ValueObject;

public class InterestRate extends ValueObject {

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public InterestRate(Integer value) {
        this.value = value;
    }
}
