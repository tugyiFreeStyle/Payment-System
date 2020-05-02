package com.customerContext.domain.shared;

public interface Policy<T> {

    void apply(T obj) throws Exception;
}
