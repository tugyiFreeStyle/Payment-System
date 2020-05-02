package com.customerContext.domain.customer;

import com.customerContext.domain.shared.ValueObject;

import java.util.UUID;

public class CustomerId extends ValueObject {

    private  String id;

    public String getId() {
        return id;
    }

    public CustomerId(String id) {
        this.id = id;
    }

    public  static CustomerId generate(){
        return new CustomerId(UUID.randomUUID().toString());
    }
}
