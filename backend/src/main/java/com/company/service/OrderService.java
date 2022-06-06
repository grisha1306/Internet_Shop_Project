package com.company.service;

import com.company.daoimpl.OrderDaoImpl;
import com.company.model.OrderModel;
import com.company.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderDaoImpl orderDao = new OrderDaoImpl();

    public boolean addToOrder(OrderModel orderModel) {
        return orderDao.addToOrder(orderModel);
    }

    public List<Product> getOrder(String username) {
        return orderDao.getOrder(username);
    }

    public boolean delete(Integer productId, Integer orderId, String email) {
        return orderDao.delete(productId, orderId, email);
    }
}
