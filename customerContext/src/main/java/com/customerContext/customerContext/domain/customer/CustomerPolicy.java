package com.customerContext.customerContext.domain.customer;

import com.customerContext.customerContext.domain.customer.exceptions.CustomerCannotHaveMoreThanThreeAccountsExeption;
import com.customerContext.customerContext.domain.customer.exceptions.InitialDepositCannotBelowAHundred;
import org.springframework.stereotype.Component;


@Component
public class CustomerPolicy {

    private final CustomerRepository customerRepository;

    public CustomerPolicy(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void apply(CustomerId customerId) throws CustomerCannotHaveMoreThanThreeAccountsExeption {

        Customer existingCustomer = customerRepository.get(customerId);

        if (existingCustomer != null && existingCustomer.getAccountNumbers().size() == 3) {
            throw new CustomerCannotHaveMoreThanThreeAccountsExeption(existingCustomer.getId().toString());
        }
    }


    public void apply(Money money) throws InitialDepositCannotBelowAHundred {

        if (money.getValue() < 100) {
            throw new InitialDepositCannotBelowAHundred(money.getValue());
        }
    }

    public InterestRate calculate(Money money) {

        return (money.getValue() > 50000 ? new InterestRate(2) : new InterestRate(1));
    }
}
