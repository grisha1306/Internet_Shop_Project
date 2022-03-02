package com.company.service;

import com.company.daoimpl.ObjectsDaoImpl;
import com.company.daoimpl.ParametersDaoImpl;
import com.company.model.Objects;
import com.company.model.Product;
import com.company.model.ProductInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ObjectsDaoImpl objectsDao = new ObjectsDaoImpl();
    private ParametersDaoImpl parametersDao = new ParametersDaoImpl();

    public ProductService () {}

    public List<Product> getAllProducts() {
        return objectsDao.getAllProducts();
    }

    public List<ProductInfo> getAllInfoAboutProduct(Integer productId) {
        return parametersDao.getAllInfoAboutProduct(productId);
    }

}
