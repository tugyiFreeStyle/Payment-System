package com.customerContext.customerContext.domain.customer;

import com.customerContext.customerContext.domain.shared.ValueObject;

import java.util.UUID;

public class AccountNumber extends ValueObject {

    private String value;

    public String getValue() {
        return value;
    }

    public AccountNumber(String value) {
        // validation logic
        this.value = value;
    }

    public static AccountNumber generate() {
        return new AccountNumber(UUID.randomUUID().toString());
    }
}
