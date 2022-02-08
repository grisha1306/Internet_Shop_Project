package com.company.dao;

import com.company.model.References;

import java.util.List;

public interface ReferencesDao {
    void create (References references);

    References getById (Integer id);

    void update (References references);

    void delete(References references);

    List<References> findAll();
}
