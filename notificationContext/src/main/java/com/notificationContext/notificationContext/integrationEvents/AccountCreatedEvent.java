package com.notificationContext.notificationContext.integrationEvents;

public class AccountCreatedEvent {
    private String accountNumber;

    public AccountCreatedEvent(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
