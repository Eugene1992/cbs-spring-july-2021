package com.cbs.edu.springbootdemo.service;

import java.util.Collection;

public interface GenericService<E, ID> {
    E create(E entity);

    E update(E entity);

    void delete(ID id);

    E get(ID id);

    Collection<E> getAll();

    Collection<E> getAllByUsername(String username, Integer page, Integer size);
}
