package com.company.service;

import com.company.daoimpl.ObjectsTypeDaoImpl;
import com.company.model.ObjectsType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectsTypeService {

    private ObjectsTypeDaoImpl objectsTypeDao = new ObjectsTypeDaoImpl();

    public ObjectsTypeService() {}

    public ObjectsType findObjectType(int id) {
        return objectsTypeDao.getById(id);
    }

    public void saveObjectType(ObjectsType objectsType) {
        objectsTypeDao.create(objectsType);
    }

    public void deleteObjectType(ObjectsType objectsType) {
        objectsTypeDao.delete(objectsType);
    }

    public void updateObjectType(ObjectsType objectsType) {
        objectsTypeDao.update(objectsType);
    }

    public List<ObjectsType> findAll() {
        return objectsTypeDao.findAll();
    }

}
