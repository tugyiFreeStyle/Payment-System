package com.customerContext.application;

import com.customerContext.application.dtos.CreateCustomerRequestDto;
import com.customerContext.application.services.CustomerApplicationServiceImpl;
import com.customerContext.domain.customer.CustomerPolicy;
import com.customerContext.domain.customer.CustomerRepository;
import com.customerContext.domain.customer.InterestRate;
import com.customerContext.domain.customer.Money;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public abstract class CustomerFakes {
    CustomerPolicy fakePolicy;
    CustomerRepository fakeRep;
    Money fakeMoney;
    CreateCustomerRequestDto dto;
    CustomerApplicationServiceImpl customerApplicationService;
    public CustomerFakes(){

        this.fakePolicy = Mockito.mock(CustomerPolicy.class);
        this.fakeRep = Mockito.mock(CustomerRepository.class);

        this.fakeMoney = new Money(700);
        this.dto = new CreateCustomerRequestDto(20, "qweqwe.gmail.com", fakeMoney.getValue());
        Mockito.when(this.fakePolicy.calculate(any())).thenReturn(new InterestRate(1));
    }
}
