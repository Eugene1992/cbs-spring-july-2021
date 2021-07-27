package com.cbs.edu.springbootdemo.dao;

import java.util.Collection;

public interface GenericDAO<E, ID> {
    E create(E entity);

    E update(E entity);

    void delete(ID id);

    E get(ID id);

    Collection<E> getAll();
}
