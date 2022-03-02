package com.company.dao;

import java.util.List;

public interface GenericDao <T> {

    void create (T t);

    T getById (Integer id);

    void update (T t);

    void delete(T t);

    List<T> findAll();
}
