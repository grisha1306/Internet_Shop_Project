package com.company.model;

public class Product {
    private Integer objectId;
    private String objectName;
    private String typeName;
    private Integer price;
    private Integer orderId;

    private Integer quantity;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Product(Integer objectId, Integer price) {
        this.objectId = objectId;
        this.price = price;
    }

    public Product(Integer objectId, String objectName, String typeName, Integer orderId) {
        this.objectId = objectId;
        this.objectName = objectName;
        this.typeName = typeName;
        this.orderId = orderId;
    }

    public Product(Integer objectId, String objectName, String typeName) {
        this.objectId = objectId;
        this.objectName = objectName;
        this.typeName = typeName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }
    public Product () {}

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

