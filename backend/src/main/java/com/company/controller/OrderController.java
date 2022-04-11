package com.company.controller;

import com.company.model.OrderModel;
import com.company.model.Orders;
import com.company.model.Product;
import com.company.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/addToOrder")
    public void addToOrder(@RequestBody OrderModel orderModel) {
        orderService.addToOrder(orderModel);
    }

    @GetMapping("/getOrder/{username}")
    public List<Product> getOrder(@PathVariable String username) {
        return orderService.getOrder(username);
    }

    @DeleteMapping(value = "/deleteProduct/{productId}/{email}")
    public ResponseEntity<Integer> deletePost(@PathVariable Integer productId, @PathVariable String email) {

        boolean isRemoved = orderService.delete(productId, email);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(productId, HttpStatus.OK);
    }

}
