package com.company.dao;

import com.company.model.User;

import javax.persistence.criteria.CriteriaBuilder;

public interface UserDao {
    User findByUsername(String username);

    boolean save(User user);

    boolean deleteUser(Integer id);
}
