package com.tmps.project.service;

import java.util.List;

public interface Service<T, ID> {
    List<T> getAll();

    T getById(ID id);

    T create(T t);

    T updateById(ID id, T t);

    void deleteById(ID id);

    void verifyEntityById(ID id);

}