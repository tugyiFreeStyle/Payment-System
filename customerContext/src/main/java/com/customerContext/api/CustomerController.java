package com.customerContext.api;


import com.customerContext.application.dtos.CreateCustomerRequestDto;
import com.customerContext.application.dtos.CreateCustomerResponseDto;
import com.customerContext.application.services.CustomerApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerApplicationService customerApplicationService;


    @Autowired
    public CustomerController(CustomerApplicationService customerApplicationService){
        this.customerApplicationService = customerApplicationService;
    }

    @PostMapping("/")
    public CreateCustomerResponseDto create(@RequestBody CreateCustomerRequestDto dto) throws Exception {
        return customerApplicationService.create(dto);
    }

    @GetMapping("/")
    public String get() throws Exception {
        return "tugce";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable("id") String id) throws Exception {
        return "tugce  "+id;
    }


//Dependency inversion
}
