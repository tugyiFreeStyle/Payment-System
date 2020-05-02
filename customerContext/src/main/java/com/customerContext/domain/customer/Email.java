package com.customerContext.domain.customer;

import com.customerContext.domain.shared.ValueObject;

public class Email extends ValueObject {

    private String value;

    public String getValue() {
        return value;
    }

    public Email(String value) throws Exception {
//        if (value.length() < 8) {
//            throw new Exception("invalid value");
//        }
        //Validate email address with regex
        this.value = value;
    }
}
