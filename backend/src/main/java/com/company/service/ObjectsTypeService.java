package com.company.service;

import com.company.daoimpl.ObjectsTypeDaoImpl;
import com.company.model.ObjectType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectsTypeService {

    private ObjectsTypeDaoImpl objectsTypeDao = new ObjectsTypeDaoImpl();

    public ObjectsTypeService() {}

    public ObjectType findObjectType(int id) {
        return objectsTypeDao.getById(id);
    }

    public void saveObjectType(ObjectType objectType) {
        objectsTypeDao.save(objectType);
    }

    public void deleteObjectType(ObjectType objectType) {
        objectsTypeDao.delete(objectType);
    }

    public void updateObjectType(ObjectType objectType) {
        objectsTypeDao.update(objectType);
    }

    public List<ObjectType> findAll() {
        return objectsTypeDao.findAll();
    }

}
