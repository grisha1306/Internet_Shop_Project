package com.company.controller;

import com.company.daoimpl.UserDaoImpl;
import com.company.model.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public Principal user(Principal user){
        return user;
    }

    @PostMapping("/registration")
    public List<String> registration(@RequestBody User user){
        List<String> list = new ArrayList<>();

        if ( !user.getPassword().equals(user.getConfirmPassword())) {

            list.add("incorrectPass");
            return  list;
        }
        if (!userService.save(user)){
            list.add("User was found");
            return list;
        }
        list.add("Ok");
        return list;
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers () {
        return userService.getAllUsers();
    }

    @DeleteMapping("/deleteUser/{userId}")
    public boolean deleteUser(@PathVariable Integer userId) {
        return userService.deleteUser(userId);
    }
}
