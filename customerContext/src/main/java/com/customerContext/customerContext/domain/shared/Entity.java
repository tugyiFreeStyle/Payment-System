package com.customerContext.customerContext.domain.shared;


public abstract class Entity<TKey> {

    public TKey id;

    public Entity(TKey id) {
        this.id = id;
    }

    public TKey getId() {
        return id;
    }
}
