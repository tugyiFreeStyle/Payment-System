package com.customerContext.domain.customer;

import com.customerContext.domain.shared.ValueObject;


public class Money extends ValueObject {

    private double value;

    public double getValue() {
        return value;
    }

    public Money(double value) {
        this.value = value;
    }
}
