package com.company.service;

import com.company.daoimpl.UserDaoImpl;
import com.company.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public boolean save (User user) {
        return userDao.save(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public boolean deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }
}
