package com.company.service;

import com.company.daoimpl.ReferencesDaoImpl;
import com.company.model.References;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferencesService {

    private ReferencesDaoImpl referencesDao = new ReferencesDaoImpl();

    public ReferencesService() {
    }

    public References findReference(int id) {
        return referencesDao.getById(id);
    }

    public void saveReference(References references) {
        referencesDao.create(references);
    }

    public void deleteReference(References references) {
        referencesDao.delete(references);
    }

    public void updateReference(References references) {
        referencesDao.update(references);
    }

    public List<References> findAll() {
        return referencesDao.findAll();
    }
}
