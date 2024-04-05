package com.example.springexample.services;

import java.util.Collection;

public interface CRUDServices<T> {
    T getById(Long id);
    Collection<T> getAll();
    void create(T news);
    void update(Long id, T news);
    void deleteById(Long id);

}
