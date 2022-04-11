package com.company.service;

import com.company.daoimpl.OrderDaoImpl;
import com.company.model.OrderModel;
import com.company.model.Orders;
import com.company.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderDaoImpl orderDao = new OrderDaoImpl();

    public void addToOrder(OrderModel orderModel) {
        orderDao.addToOrder(orderModel);
    }

    public List<Product> getOrder(String username) {
        return orderDao.getOrder(username);
    }

    public boolean delete(Integer productId, String email) {
        return orderDao.delete(productId, email);
    }
}
