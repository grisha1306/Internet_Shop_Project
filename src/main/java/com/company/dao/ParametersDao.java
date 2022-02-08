package com.company.dao;

import com.company.model.Parameters;

import java.util.List;

public interface ParametersDao {

    void create (Parameters parameters);

    Parameters getById (Integer id);

    void update (Parameters parameters);

    void delete(Parameters parameters);

    List<Parameters> findAll();
}
