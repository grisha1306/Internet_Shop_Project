package com.company.controller;

import com.company.model.OrderModel;
import com.company.model.Product;
import com.company.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/addToOrder")
    public boolean addToOrder(@RequestBody OrderModel orderModel) {
        return orderService.addToOrder(orderModel);
    }

    @GetMapping("/getOrder/{username}")
    public List<Product> getOrder(@PathVariable String username) {
        return orderService.getOrder(username);
    }

    @DeleteMapping(value = "/deleteProduct/{productId}/{orderId}/{email}")
    public boolean deletePost(@PathVariable Integer productId, @PathVariable Integer orderId, @PathVariable String email) {

        boolean isRemoved = orderService.delete(productId, orderId, email);

        return isRemoved;

//        if (!isRemoved) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(productId, HttpStatus.OK);
    }

}
