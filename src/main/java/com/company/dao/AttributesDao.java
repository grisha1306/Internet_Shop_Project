package com.company.dao;

import com.company.model.Attributes;

import java.util.List;

public interface AttributesDao {

    void create (Attributes attributes);

    Attributes getById (Integer id);

    void update (Attributes attributes);

    void delete(Attributes attributes);

    List<Attributes> findAll();
}
