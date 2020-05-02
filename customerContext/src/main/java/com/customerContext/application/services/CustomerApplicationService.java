package com.customerContext.application.services;

import com.customerContext.application.dtos.CreateCustomerResponseDto;
import com.customerContext.application.dtos.CreateCustomerRequestDto;

public interface CustomerApplicationService {

 public CreateCustomerResponseDto create (CreateCustomerRequestDto createCustomerRequestDto) throws Exception;

}
//interface segrategation