package org.loam.common.core.bean.entity;

public class BaseEntity<T> {

    protected T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
