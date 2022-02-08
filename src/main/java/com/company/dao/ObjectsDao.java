package com.company.dao;

import com.company.model.Objects;

import java.util.List;

public interface ObjectsDao {

    void create (Objects objects);

    Objects getById (Integer id);

    void update (Objects objects);

    void delete(Objects objects);

    List<Objects> findAll();
}
