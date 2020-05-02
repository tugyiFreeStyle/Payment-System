package com.customerContext.customerContext.domain.customer.exceptions;

public class CustomerCannotHaveMoreThanThreeAccountsExeption extends Exception {

    public CustomerCannotHaveMoreThanThreeAccountsExeption(String customerId) {
        super(customerId);
    }
}
