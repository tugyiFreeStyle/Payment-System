package com.customerContext.customerContext.application;

import com.customerContext.customerContext.application.dtos.CreateCustomerResponseDto;
import com.customerContext.customerContext.application.services.CustomerApplicationServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class When_create_customer extends CustomerFakes {

    CreateCustomerResponseDto result;

    public When_create_customer() throws Exception {

        this.customerApplicationService = new CustomerApplicationServiceImpl(fakeRep, fakePolicy, event -> true);
        this.result = customerApplicationService.create(dto);
    }


    @Test
    public void then_should_not_be_null() throws Exception {
        assertThat(customerApplicationService).isNotNull();
        assertThat(result).isNotNull();
    }

    @Test
    public void then_should_customerid_return() throws Exception {
        assertThat(result.getCustomerId()).isNotNull();
        assertThat(result.getAccountNumber()).hasSizeGreaterThan(0);
    }
//tdd : london style top to bottom, detroit style(chicago) bottom to top = ddd
}
