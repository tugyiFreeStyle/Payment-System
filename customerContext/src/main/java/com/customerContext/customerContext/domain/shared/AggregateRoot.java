package com.customerContext.customerContext.domain.shared;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot<TKey>  extends  Entity<TKey>{

    private List<Object> events;

    public AggregateRoot(TKey id) {
        super(id);
        events= new ArrayList<>();
    }

    protected void addEvent(Object event){
        events.add(event);
    }

    public List<Object> getEvents(){
        return  events;
    }
}
