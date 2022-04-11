package com.company.model;

public class OrderModel {

    private String email;
    private Integer productId;

    public OrderModel() {
    }

    public OrderModel(String email, Integer productId) {
        this.email = email;
        this.productId = productId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
