package com.company.dao;

import com.company.model.Objects;
import com.company.model.ObjectsType;

import java.util.List;

public interface ObjectsTypeDao {

    void create (ObjectsType objectsType);

    ObjectsType getById (Integer id);

    void update (ObjectsType objectsType);

    void delete(ObjectsType objectsType);

    List<ObjectsType> findAll();
}
