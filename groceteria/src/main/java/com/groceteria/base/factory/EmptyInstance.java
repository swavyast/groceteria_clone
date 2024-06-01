package com.groceteria.base.factory;

import com.groceteria.base.exception.InstantiationFailedException;

public interface EmptyInstance<T> {
    T forClass(Class<T> clazz) throws InstantiationFailedException;
}
