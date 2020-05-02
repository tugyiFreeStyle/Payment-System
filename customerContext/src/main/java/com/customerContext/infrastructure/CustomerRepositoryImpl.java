package com.customerContext.infrastructure;

import com.customerContext.domain.customer.Customer;
import com.customerContext.domain.customer.CustomerId;
import com.customerContext.domain.customer.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;


@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private static ConcurrentHashMap<CustomerId, Customer> customers = new ConcurrentHashMap<>();

    @Override
    public Customer get(CustomerId customerId) {
        return customers.get(customerId);
    }

    @Override
    public Customer get(Predicate<Customer> when) {
        return null;
    }

    @Override
    public void create(Customer customer) {
        customers.put(customer.getId(), customer);
    }
}
