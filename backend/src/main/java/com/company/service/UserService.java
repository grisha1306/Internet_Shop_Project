package com.company.service;

import com.company.daoimpl.UserDaoImpl;
import com.company.daoimpl.UserRoleDaoImpl;
import com.company.model.User;
import com.company.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    UserDaoImpl userDao = new UserDaoImpl();
    UserRoleDaoImpl userRoleDao = new UserRoleDaoImpl();

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return (UserDetails) user;
    }


    public User findUserById(Integer userId) {
        Optional<User> userFromDb = Optional.ofNullable(userDao.getById(userId));
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userDao.findAll();
    }

    public boolean saveUser(User user) {
        User userFromDB = userDao.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(new UserRole(1, "ROLE_USER"));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.create(user);
        return true;
    }

    public boolean deleteUser(Integer userId) {
        if (userDao.getById(userId) != null) {
            userDao.deleteById(userId);
            return true;
        }
        return false;
    }


}
