package com.company.service;

import com.company.daoimpl.ObjectsDaoImpl;
import com.company.model.Objects;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectsService {

    private ObjectsDaoImpl objectsDao = new ObjectsDaoImpl();

    public ObjectsService() {}

    public Objects findObject(int id) {
        return objectsDao.getById(id);
    }

    public void saveObject(Objects objects) {
        objectsDao.save(objects);
    }

    public void deleteObject(Objects objects) {
        objectsDao.delete(objects);
    }

    public void updateObject(Objects objects) {
        objectsDao.update(objects);
    }

    public List<Objects> findAll() {
        return objectsDao.findAll();
    }
}
