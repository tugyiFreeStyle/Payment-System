package com.customerContext.customerContext.infrastructure.eventBus;

@FunctionalInterface
public interface EventBus {
    boolean send(Object event);

}
