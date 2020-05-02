package com.customerContext.application.assembler;

import com.customerContext.application.dtos.CreateCustomerResponseDto;
import com.customerContext.domain.customer.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
//domain name packaging
public class CustomerAssembler {
    //Extract Class


    public CreateCustomerResponseDto mapTo(Customer customer)
    {
        CreateCustomerResponseDto createCustomerResponseDto = new CreateCustomerResponseDto();
        createCustomerResponseDto.setAccountNumber(customer.getAccountNumbers().stream().map(accNumber -> accNumber.getValue()).collect(Collectors.toList()));
        createCustomerResponseDto.setCustomerId(customer.getId().toString());
        return createCustomerResponseDto;

    }
}
