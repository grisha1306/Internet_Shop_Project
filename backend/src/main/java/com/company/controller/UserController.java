package com.company.controller;

import com.company.model.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping("/user/{username}")
//    public User getAllProducts(@PathVariable(value = "username") String username){
//        User user = userService.findUserByUsername(username);
//        return userService.findUserByUsername(username);
//    }


}
