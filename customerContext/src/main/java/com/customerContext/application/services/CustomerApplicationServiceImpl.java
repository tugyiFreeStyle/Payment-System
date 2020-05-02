package com.customerContext.application.services;


import com.customerContext.application.dtos.CreateCustomerResponseDto;
import com.customerContext.application.dtos.CreateCustomerRequestDto;
import com.customerContext.domain.customer.*;
import com.customerContext.infrastructure.eventBus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class CustomerApplicationServiceImpl implements CustomerApplicationService {

    private final CustomerRepository customerRepository;
    private final CustomerPolicy customerPolicy;
    private final EventBus eventBus; //function
    //depend on a function instead of interface


    @Autowired
    public CustomerApplicationServiceImpl(CustomerRepository customerRepository,
                                          CustomerPolicy customerPolicy,
                                          EventBus eventBus) {
        this.customerRepository = customerRepository;
        this.customerPolicy = customerPolicy;
        this.eventBus = eventBus;
    }

    @Override
    public CreateCustomerResponseDto create(CreateCustomerRequestDto createCustomerRequestDto) throws Exception {
        AccountNumber newAccNumber = AccountNumber.generate();

        Customer customer = Customer.create(CustomerId.generate(),
                new Email(createCustomerRequestDto.getEmail()),
                newAccNumber,
                new Age(createCustomerRequestDto.getAge()),
                new Money(createCustomerRequestDto.getMoney()),
                customerPolicy);

        //Rabbitmq publish edilen yer!!!
        customer.getEvents().stream().forEach(event -> {
            eventBus.send(event);
        });
        //log
        customerRepository.create(customer);

        CreateCustomerResponseDto createCustomerResponseDto = new CreateCustomerResponseDto();
        createCustomerResponseDto.setAccountNumber(customer.getAccountNumbers().stream().map(accNumber -> accNumber.getValue()).collect(Collectors.toList()));
        createCustomerResponseDto.setCustomerId(customer.getId().toString());
        return createCustomerResponseDto;
    }
}
