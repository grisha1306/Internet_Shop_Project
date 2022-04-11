package com.company.dao;

import com.company.model.OrderModel;
import com.company.model.Product;

import java.util.List;

public interface OrderDao {

    void addToOrder(OrderModel orderModel);

    List<Product> getOrder(String username);

    boolean delete(Integer productId, String email);
}
