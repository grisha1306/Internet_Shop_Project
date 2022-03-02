package com.company.model;

import org.springframework.security.core.GrantedAuthority;

public class UserRole implements GrantedAuthority {

    private int id;
    private String name;

    public UserRole() {
    }

    public UserRole(int id) {
        this.id = id;
    }

    public UserRole(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
