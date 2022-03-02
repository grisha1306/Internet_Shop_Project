package com.company.service;

import com.company.daoimpl.AttributesDaoImpl;
import com.company.model.Attributes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributesService {

    private AttributesDaoImpl attributesDao = new AttributesDaoImpl();

    public AttributesService() {
    }

    public Attributes findAttribute(int id) {
        return attributesDao.getById(id);
    }

    public void createAttribute(Attributes attributes) {
        attributesDao.create(attributes);
    }

    public void deleteAttribute(Attributes attributes) {
        attributesDao.delete(attributes);
    }

    public void updateAttribute(Attributes attributes) {
        attributesDao.update(attributes);
    }

    public List<Attributes> findAll() {
        return attributesDao.findAll();
    }
}
