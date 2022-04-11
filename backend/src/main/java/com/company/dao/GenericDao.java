package com.company.dao;

import java.util.List;

public interface GenericDao <T> {

    void save (T t);

    T getById (Integer id);

    void update (T t);

    void delete(T t);

    List<T> findAll();
}
