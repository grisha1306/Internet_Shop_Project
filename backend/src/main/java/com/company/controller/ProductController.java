package com.company.controller;

import com.company.model.Objects;
import com.company.model.Product;
import com.company.model.ProductInfo;
import com.company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/infoAboutProduct/{id}")
    public List<ProductInfo> getAllInfoAboutProduct(@PathVariable(value = "id") Integer id){
        return productService.getAllInfoAboutProduct(id);

    }
}
