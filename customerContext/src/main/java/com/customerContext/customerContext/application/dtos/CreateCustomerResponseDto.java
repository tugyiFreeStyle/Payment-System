package com.customerContext.customerContext.application.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CreateCustomerResponseDto {

    private List<String> accountNumber;
    private String customerId;
}
