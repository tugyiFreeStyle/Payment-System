package com.customerContext.domain.customer.exceptions;

public class AgeConnotBeloweighteenException extends Exception {

    public AgeConnotBeloweighteenException(int age) {
        super("age cannot below 18" + age  );
    }
}
