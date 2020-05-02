package com.customerContext.customerContext.application.dtos;

import lombok.Value;

@Value
public class CreateCustomerRequestDto {
    private int age;
    private String email;
    private double money;
}
