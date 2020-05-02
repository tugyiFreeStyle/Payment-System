package com.customerContext.domain.customer;


import com.customerContext.domain.customer.events.AccountCreatedEvent;
import com.customerContext.domain.shared.AggregateRoot;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Customer extends AggregateRoot<CustomerId> {

    private Email email;
    private List<AccountNumber> accountNumbers = new ArrayList<>();
    private Age age;
    private Money money;
    private InterestRate interestRate;

    private Customer(CustomerId id,
                     Email email,
                     AccountNumber accountNumber,
                     Age age,
                     Money money) {
        super(id);
        this.email = email;
        this.accountNumbers.add(accountNumber);
        this.age = age;
        this.money = money;
    }

    private Customer(CustomerId customerId,
                     Email email,
                     AccountNumber accountNumber,
                     Age age,
                     Money money,
                     CustomerPolicy customerPolicy) throws Exception {

        this(customerId, email, accountNumber, age, money);

        customerPolicy.apply(customerId);
        customerPolicy.apply(money);
        this.interestRate = customerPolicy.calculate(money);

        //collection addding
        addEvent(new AccountCreatedEvent(customerId.getId(), accountNumber.getValue(), money.getValue(), interestRate.getValue()));
    }

    public static Customer create(CustomerId customerId,
                                  Email email,
                                  AccountNumber accountNumber,
                                  Age age,
                                  Money money,
                                  CustomerPolicy customerPolicy) throws Exception {

        return new Customer(customerId, email, accountNumber, age, money, customerPolicy);
    }

}
