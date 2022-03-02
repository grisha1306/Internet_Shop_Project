package com.company.dao;

import com.company.model.User;

public interface UserDao {
    User findByUsername(String username);
}
