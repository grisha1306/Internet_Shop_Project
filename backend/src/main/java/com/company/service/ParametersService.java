package com.company.service;

import com.company.daoimpl.ParametersDaoImpl;
import com.company.model.Parameters;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParametersService {

    private ParametersDaoImpl parametersDao = new ParametersDaoImpl();

    public ParametersService() {
    }

    public Parameters findParameter(int id) {
        return parametersDao.getById(id);
    }

    public void saveParameter(Parameters parameters) {
        parametersDao.save(parameters);
    }

    public void deleteParameter(Parameters parameters) {
        parametersDao.delete(parameters);
    }

    public void updateParameter(Parameters parameters) {
        parametersDao.update(parameters);
    }

    public List<Parameters> findAll() {
        return parametersDao.findAll();
    }

}
