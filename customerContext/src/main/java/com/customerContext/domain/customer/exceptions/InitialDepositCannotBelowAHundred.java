package com.customerContext.domain.customer.exceptions;

public class InitialDepositCannotBelowAHundred extends Exception {

    public InitialDepositCannotBelowAHundred(double money) {
        super("Inital deposit cannot below 100" + money);
    }
}
