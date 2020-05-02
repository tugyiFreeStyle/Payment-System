package com.customerContext.customerContext.application.services;

import com.customerContext.customerContext.application.dtos.CreateCustomerRequestDto;
import com.customerContext.customerContext.application.dtos.CreateCustomerResponseDto;

public interface CustomerApplicationService {

 public CreateCustomerResponseDto create (CreateCustomerRequestDto createCustomerRequestDto) throws Exception;

}
//interface segrategation