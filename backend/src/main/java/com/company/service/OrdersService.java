package com.company.service;

import com.company.daoimpl.ReferencesDaoImpl;
import com.company.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    private ReferencesDaoImpl referencesDao = new ReferencesDaoImpl();

    public OrdersService() {
    }

    public Orders findReference(int id) {
        return referencesDao.getById(id);
    }

    public void saveReference(Orders orders) {
        referencesDao.save(orders);
    }

    public void deleteReference(Orders orders) {
        referencesDao.delete(orders);
    }

    public void updateReference(Orders orders) {
        referencesDao.update(orders);
    }

    public List<Orders> findAll() {
        return referencesDao.findAll();
    }
}
