package com.customerContext.customerContext.domain.customer;


import java.util.function.Predicate;


public interface CustomerRepository {

    Customer get(CustomerId customerId);

    Customer get(Predicate<Customer> when);

    void create(Customer customer);

}
