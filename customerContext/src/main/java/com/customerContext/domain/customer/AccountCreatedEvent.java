package com.customerContext.domain.customer;

import lombok.Getter;

@Getter
public class AccountCreatedEvent {

    private String customerId;
    private String accountNumber;
    private Double deposit;
    private int interestRate;

    public AccountCreatedEvent(String customerId, String accountNumber, Double deposit, int interestRate) {
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.deposit = deposit;
        this.interestRate = interestRate;
    }
}
