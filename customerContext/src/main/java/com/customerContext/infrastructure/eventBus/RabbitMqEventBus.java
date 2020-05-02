package com.customerContext.infrastructure.eventBus;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@EnableBinding(Source.class)
@Component
public class RabbitMqEventBus implements EventBus {


    private final Source source;

    public RabbitMqEventBus(Source source) {
        this.source = source;
    }

    @Override
    public boolean send(Object event) {
       return source.output().send(MessageBuilder.withPayload(event).build());
    }
}
