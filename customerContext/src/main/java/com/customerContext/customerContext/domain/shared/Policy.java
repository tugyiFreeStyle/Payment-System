package com.customerContext.customerContext.domain.shared;

import com.customerContext.customerContext.domain.customer.CustomerRepository;

public interface Policy<T> {

    void apply(T obj) throws Exception;
}
